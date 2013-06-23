/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewProductoFactura;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author User
 */
public class ViewProductoFacturaDAO implements Serializable {

    public ViewProductoFacturaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewProductoFactura viewProductoFactura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewProductoFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewProductoFactura(viewProductoFactura.getIdFactura()) != null) {
                throw new PreexistingEntityException("ViewProductoFactura " + viewProductoFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewProductoFactura viewProductoFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewProductoFactura = em.merge(viewProductoFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewProductoFactura.getIdFactura();
                if (findViewProductoFactura(id) == null) {
                    throw new NonexistentEntityException("The viewProductoFactura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewProductoFactura viewProductoFactura;
            try {
                viewProductoFactura = em.getReference(ViewProductoFactura.class, id);
                viewProductoFactura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewProductoFactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewProductoFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewProductoFactura> findViewProductoFacturaEntities() {
        return findViewProductoFacturaEntities(true, -1, -1);
    }

    public List<ViewProductoFactura> findViewProductoFacturaEntities(int maxResults, int firstResult) {
        return findViewProductoFacturaEntities(false, maxResults, firstResult);
    }

    private List<ViewProductoFactura> findViewProductoFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewProductoFactura.class));
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

    public ViewProductoFactura findViewProductoFactura(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewProductoFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewProductoFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewProductoFactura> rt = cq.from(ViewProductoFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
