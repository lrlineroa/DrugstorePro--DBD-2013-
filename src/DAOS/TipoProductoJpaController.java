/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.IllegalOrphanException;
import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Medicamento;
import Entities.TipoProducto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class TipoProductoJpaController implements Serializable {

    public TipoProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoProducto tipoProducto) throws PreexistingEntityException, Exception {
        if (tipoProducto.getMedicamentoList() == null) {
            tipoProducto.setMedicamentoList(new ArrayList<Medicamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : tipoProducto.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            tipoProducto.setMedicamentoList(attachedMedicamentoList);
            em.persist(tipoProducto);
            for (Medicamento medicamentoListMedicamento : tipoProducto.getMedicamentoList()) {
                TipoProducto oldIdTipoProductoOfMedicamentoListMedicamento = medicamentoListMedicamento.getIdTipoProducto();
                medicamentoListMedicamento.setIdTipoProducto(tipoProducto);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
                if (oldIdTipoProductoOfMedicamentoListMedicamento != null) {
                    oldIdTipoProductoOfMedicamentoListMedicamento.getMedicamentoList().remove(medicamentoListMedicamento);
                    oldIdTipoProductoOfMedicamentoListMedicamento = em.merge(oldIdTipoProductoOfMedicamentoListMedicamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoProducto(tipoProducto.getIdTipoProducto()) != null) {
                throw new PreexistingEntityException("TipoProducto " + tipoProducto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoProducto tipoProducto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoProducto persistentTipoProducto = em.find(TipoProducto.class, tipoProducto.getIdTipoProducto());
            List<Medicamento> medicamentoListOld = persistentTipoProducto.getMedicamentoList();
            List<Medicamento> medicamentoListNew = tipoProducto.getMedicamentoList();
            List<String> illegalOrphanMessages = null;
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Medicamento " + medicamentoListOldMedicamento + " since its idTipoProducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Medicamento> attachedMedicamentoListNew = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListNewMedicamentoToAttach : medicamentoListNew) {
                medicamentoListNewMedicamentoToAttach = em.getReference(medicamentoListNewMedicamentoToAttach.getClass(), medicamentoListNewMedicamentoToAttach.getIdProducto());
                attachedMedicamentoListNew.add(medicamentoListNewMedicamentoToAttach);
            }
            medicamentoListNew = attachedMedicamentoListNew;
            tipoProducto.setMedicamentoList(medicamentoListNew);
            tipoProducto = em.merge(tipoProducto);
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    TipoProducto oldIdTipoProductoOfMedicamentoListNewMedicamento = medicamentoListNewMedicamento.getIdTipoProducto();
                    medicamentoListNewMedicamento.setIdTipoProducto(tipoProducto);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                    if (oldIdTipoProductoOfMedicamentoListNewMedicamento != null && !oldIdTipoProductoOfMedicamentoListNewMedicamento.equals(tipoProducto)) {
                        oldIdTipoProductoOfMedicamentoListNewMedicamento.getMedicamentoList().remove(medicamentoListNewMedicamento);
                        oldIdTipoProductoOfMedicamentoListNewMedicamento = em.merge(oldIdTipoProductoOfMedicamentoListNewMedicamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = tipoProducto.getIdTipoProducto();
                if (findTipoProducto(id) == null) {
                    throw new NonexistentEntityException("The tipoProducto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoProducto tipoProducto;
            try {
                tipoProducto = em.getReference(TipoProducto.class, id);
                tipoProducto.getIdTipoProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoProducto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Medicamento> medicamentoListOrphanCheck = tipoProducto.getMedicamentoList();
            for (Medicamento medicamentoListOrphanCheckMedicamento : medicamentoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TipoProducto (" + tipoProducto + ") cannot be destroyed since the Medicamento " + medicamentoListOrphanCheckMedicamento + " in its medicamentoList field has a non-nullable idTipoProducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipoProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoProducto> findTipoProductoEntities() {
        return findTipoProductoEntities(true, -1, -1);
    }

    public List<TipoProducto> findTipoProductoEntities(int maxResults, int firstResult) {
        return findTipoProductoEntities(false, maxResults, firstResult);
    }

    private List<TipoProducto> findTipoProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoProducto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoProducto findTipoProducto(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoProducto> rt = cq.from(TipoProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
