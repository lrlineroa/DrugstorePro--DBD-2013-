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
import Entities.TipoProveedor;
import java.util.ArrayList;
import java.util.List;
import Entities.Medicamento;
import Entities.Proveedor;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) throws PreexistingEntityException, Exception {
        if (proveedor.getTipoProveedorList() == null) {
            proveedor.setTipoProveedorList(new ArrayList<TipoProveedor>());
        }
        if (proveedor.getMedicamentoList() == null) {
            proveedor.setMedicamentoList(new ArrayList<Medicamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TipoProveedor> attachedTipoProveedorList = new ArrayList<TipoProveedor>();
            for (TipoProveedor tipoProveedorListTipoProveedorToAttach : proveedor.getTipoProveedorList()) {
                tipoProveedorListTipoProveedorToAttach = em.getReference(tipoProveedorListTipoProveedorToAttach.getClass(), tipoProveedorListTipoProveedorToAttach.getIdTipoProveedor());
                attachedTipoProveedorList.add(tipoProveedorListTipoProveedorToAttach);
            }
            proveedor.setTipoProveedorList(attachedTipoProveedorList);
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : proveedor.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            proveedor.setMedicamentoList(attachedMedicamentoList);
            em.persist(proveedor);
            for (TipoProveedor tipoProveedorListTipoProveedor : proveedor.getTipoProveedorList()) {
                tipoProveedorListTipoProveedor.getProveedorList().add(proveedor);
                tipoProveedorListTipoProveedor = em.merge(tipoProveedorListTipoProveedor);
            }
            for (Medicamento medicamentoListMedicamento : proveedor.getMedicamentoList()) {
                Proveedor oldIdProveedorOfMedicamentoListMedicamento = medicamentoListMedicamento.getIdProveedor();
                medicamentoListMedicamento.setIdProveedor(proveedor);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
                if (oldIdProveedorOfMedicamentoListMedicamento != null) {
                    oldIdProveedorOfMedicamentoListMedicamento.getMedicamentoList().remove(medicamentoListMedicamento);
                    oldIdProveedorOfMedicamentoListMedicamento = em.merge(oldIdProveedorOfMedicamentoListMedicamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProveedor(proveedor.getIdProveedor()) != null) {
                throw new PreexistingEntityException("Proveedor " + proveedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getIdProveedor());
            List<TipoProveedor> tipoProveedorListOld = persistentProveedor.getTipoProveedorList();
            List<TipoProveedor> tipoProveedorListNew = proveedor.getTipoProveedorList();
            List<Medicamento> medicamentoListOld = persistentProveedor.getMedicamentoList();
            List<Medicamento> medicamentoListNew = proveedor.getMedicamentoList();
            List<String> illegalOrphanMessages = null;
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Medicamento " + medicamentoListOldMedicamento + " since its idProveedor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<TipoProveedor> attachedTipoProveedorListNew = new ArrayList<TipoProveedor>();
            for (TipoProveedor tipoProveedorListNewTipoProveedorToAttach : tipoProveedorListNew) {
                tipoProveedorListNewTipoProveedorToAttach = em.getReference(tipoProveedorListNewTipoProveedorToAttach.getClass(), tipoProveedorListNewTipoProveedorToAttach.getIdTipoProveedor());
                attachedTipoProveedorListNew.add(tipoProveedorListNewTipoProveedorToAttach);
            }
            tipoProveedorListNew = attachedTipoProveedorListNew;
            proveedor.setTipoProveedorList(tipoProveedorListNew);
            List<Medicamento> attachedMedicamentoListNew = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListNewMedicamentoToAttach : medicamentoListNew) {
                medicamentoListNewMedicamentoToAttach = em.getReference(medicamentoListNewMedicamentoToAttach.getClass(), medicamentoListNewMedicamentoToAttach.getIdProducto());
                attachedMedicamentoListNew.add(medicamentoListNewMedicamentoToAttach);
            }
            medicamentoListNew = attachedMedicamentoListNew;
            proveedor.setMedicamentoList(medicamentoListNew);
            proveedor = em.merge(proveedor);
            for (TipoProveedor tipoProveedorListOldTipoProveedor : tipoProveedorListOld) {
                if (!tipoProveedorListNew.contains(tipoProveedorListOldTipoProveedor)) {
                    tipoProveedorListOldTipoProveedor.getProveedorList().remove(proveedor);
                    tipoProveedorListOldTipoProveedor = em.merge(tipoProveedorListOldTipoProveedor);
                }
            }
            for (TipoProveedor tipoProveedorListNewTipoProveedor : tipoProveedorListNew) {
                if (!tipoProveedorListOld.contains(tipoProveedorListNewTipoProveedor)) {
                    tipoProveedorListNewTipoProveedor.getProveedorList().add(proveedor);
                    tipoProveedorListNewTipoProveedor = em.merge(tipoProveedorListNewTipoProveedor);
                }
            }
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    Proveedor oldIdProveedorOfMedicamentoListNewMedicamento = medicamentoListNewMedicamento.getIdProveedor();
                    medicamentoListNewMedicamento.setIdProveedor(proveedor);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                    if (oldIdProveedorOfMedicamentoListNewMedicamento != null && !oldIdProveedorOfMedicamentoListNewMedicamento.equals(proveedor)) {
                        oldIdProveedorOfMedicamentoListNewMedicamento.getMedicamentoList().remove(medicamentoListNewMedicamento);
                        oldIdProveedorOfMedicamentoListNewMedicamento = em.merge(oldIdProveedorOfMedicamentoListNewMedicamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = proveedor.getIdProveedor();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getIdProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Medicamento> medicamentoListOrphanCheck = proveedor.getMedicamentoList();
            for (Medicamento medicamentoListOrphanCheckMedicamento : medicamentoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedor (" + proveedor + ") cannot be destroyed since the Medicamento " + medicamentoListOrphanCheckMedicamento + " in its medicamentoList field has a non-nullable idProveedor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<TipoProveedor> tipoProveedorList = proveedor.getTipoProveedorList();
            for (TipoProveedor tipoProveedorListTipoProveedor : tipoProveedorList) {
                tipoProveedorListTipoProveedor.getProveedorList().remove(proveedor);
                tipoProveedorListTipoProveedor = em.merge(tipoProveedorListTipoProveedor);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
