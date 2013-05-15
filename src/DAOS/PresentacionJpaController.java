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
import Entities.Presentacion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class PresentacionJpaController implements Serializable {

    public PresentacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Presentacion presentacion) throws PreexistingEntityException, Exception {
        if (presentacion.getMedicamentoList() == null) {
            presentacion.setMedicamentoList(new ArrayList<Medicamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : presentacion.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            presentacion.setMedicamentoList(attachedMedicamentoList);
            em.persist(presentacion);
            for (Medicamento medicamentoListMedicamento : presentacion.getMedicamentoList()) {
                Presentacion oldIdPresentacionOfMedicamentoListMedicamento = medicamentoListMedicamento.getIdPresentacion();
                medicamentoListMedicamento.setIdPresentacion(presentacion);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
                if (oldIdPresentacionOfMedicamentoListMedicamento != null) {
                    oldIdPresentacionOfMedicamentoListMedicamento.getMedicamentoList().remove(medicamentoListMedicamento);
                    oldIdPresentacionOfMedicamentoListMedicamento = em.merge(oldIdPresentacionOfMedicamentoListMedicamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPresentacion(presentacion.getIdPresentacion()) != null) {
                throw new PreexistingEntityException("Presentacion " + presentacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Presentacion presentacion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Presentacion persistentPresentacion = em.find(Presentacion.class, presentacion.getIdPresentacion());
            List<Medicamento> medicamentoListOld = persistentPresentacion.getMedicamentoList();
            List<Medicamento> medicamentoListNew = presentacion.getMedicamentoList();
            List<String> illegalOrphanMessages = null;
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Medicamento " + medicamentoListOldMedicamento + " since its idPresentacion field is not nullable.");
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
            presentacion.setMedicamentoList(medicamentoListNew);
            presentacion = em.merge(presentacion);
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    Presentacion oldIdPresentacionOfMedicamentoListNewMedicamento = medicamentoListNewMedicamento.getIdPresentacion();
                    medicamentoListNewMedicamento.setIdPresentacion(presentacion);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                    if (oldIdPresentacionOfMedicamentoListNewMedicamento != null && !oldIdPresentacionOfMedicamentoListNewMedicamento.equals(presentacion)) {
                        oldIdPresentacionOfMedicamentoListNewMedicamento.getMedicamentoList().remove(medicamentoListNewMedicamento);
                        oldIdPresentacionOfMedicamentoListNewMedicamento = em.merge(oldIdPresentacionOfMedicamentoListNewMedicamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = presentacion.getIdPresentacion();
                if (findPresentacion(id) == null) {
                    throw new NonexistentEntityException("The presentacion with id " + id + " no longer exists.");
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
            Presentacion presentacion;
            try {
                presentacion = em.getReference(Presentacion.class, id);
                presentacion.getIdPresentacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The presentacion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Medicamento> medicamentoListOrphanCheck = presentacion.getMedicamentoList();
            for (Medicamento medicamentoListOrphanCheckMedicamento : medicamentoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Presentacion (" + presentacion + ") cannot be destroyed since the Medicamento " + medicamentoListOrphanCheckMedicamento + " in its medicamentoList field has a non-nullable idPresentacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(presentacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Presentacion> findPresentacionEntities() {
        return findPresentacionEntities(true, -1, -1);
    }

    public List<Presentacion> findPresentacionEntities(int maxResults, int firstResult) {
        return findPresentacionEntities(false, maxResults, firstResult);
    }

    private List<Presentacion> findPresentacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Presentacion.class));
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

    public Presentacion findPresentacion(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Presentacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getPresentacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Presentacion> rt = cq.from(Presentacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
