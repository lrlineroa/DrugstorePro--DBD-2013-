/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Proveedor;
import Entities.TipoProveedor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class TipoProveedorJpaController implements Serializable {

    public TipoProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoProveedor tipoProveedor) throws PreexistingEntityException, Exception {
        if (tipoProveedor.getProveedorList() == null) {
            tipoProveedor.setProveedorList(new ArrayList<Proveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Proveedor> attachedProveedorList = new ArrayList<Proveedor>();
            for (Proveedor proveedorListProveedorToAttach : tipoProveedor.getProveedorList()) {
                proveedorListProveedorToAttach = em.getReference(proveedorListProveedorToAttach.getClass(), proveedorListProveedorToAttach.getIdProveedor());
                attachedProveedorList.add(proveedorListProveedorToAttach);
            }
            tipoProveedor.setProveedorList(attachedProveedorList);
            em.persist(tipoProveedor);
            for (Proveedor proveedorListProveedor : tipoProveedor.getProveedorList()) {
                proveedorListProveedor.getTipoProveedorList().add(tipoProveedor);
                proveedorListProveedor = em.merge(proveedorListProveedor);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoProveedor(tipoProveedor.getIdTipoProveedor()) != null) {
                throw new PreexistingEntityException("TipoProveedor " + tipoProveedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoProveedor tipoProveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoProveedor persistentTipoProveedor = em.find(TipoProveedor.class, tipoProveedor.getIdTipoProveedor());
            List<Proveedor> proveedorListOld = persistentTipoProveedor.getProveedorList();
            List<Proveedor> proveedorListNew = tipoProveedor.getProveedorList();
            List<Proveedor> attachedProveedorListNew = new ArrayList<Proveedor>();
            for (Proveedor proveedorListNewProveedorToAttach : proveedorListNew) {
                proveedorListNewProveedorToAttach = em.getReference(proveedorListNewProveedorToAttach.getClass(), proveedorListNewProveedorToAttach.getIdProveedor());
                attachedProveedorListNew.add(proveedorListNewProveedorToAttach);
            }
            proveedorListNew = attachedProveedorListNew;
            tipoProveedor.setProveedorList(proveedorListNew);
            tipoProveedor = em.merge(tipoProveedor);
            for (Proveedor proveedorListOldProveedor : proveedorListOld) {
                if (!proveedorListNew.contains(proveedorListOldProveedor)) {
                    proveedorListOldProveedor.getTipoProveedorList().remove(tipoProveedor);
                    proveedorListOldProveedor = em.merge(proveedorListOldProveedor);
                }
            }
            for (Proveedor proveedorListNewProveedor : proveedorListNew) {
                if (!proveedorListOld.contains(proveedorListNewProveedor)) {
                    proveedorListNewProveedor.getTipoProveedorList().add(tipoProveedor);
                    proveedorListNewProveedor = em.merge(proveedorListNewProveedor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = tipoProveedor.getIdTipoProveedor();
                if (findTipoProveedor(id) == null) {
                    throw new NonexistentEntityException("The tipoProveedor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoProveedor tipoProveedor;
            try {
                tipoProveedor = em.getReference(TipoProveedor.class, id);
                tipoProveedor.getIdTipoProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoProveedor with id " + id + " no longer exists.", enfe);
            }
            List<Proveedor> proveedorList = tipoProveedor.getProveedorList();
            for (Proveedor proveedorListProveedor : proveedorList) {
                proveedorListProveedor.getTipoProveedorList().remove(tipoProveedor);
                proveedorListProveedor = em.merge(proveedorListProveedor);
            }
            em.remove(tipoProveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoProveedor> findTipoProveedorEntities() {
        return findTipoProveedorEntities(true, -1, -1);
    }

    public List<TipoProveedor> findTipoProveedorEntities(int maxResults, int firstResult) {
        return findTipoProveedorEntities(false, maxResults, firstResult);
    }

    private List<TipoProveedor> findTipoProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoProveedor.class));
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

    public TipoProveedor findTipoProveedor(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoProveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoProveedor> rt = cq.from(TipoProveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
