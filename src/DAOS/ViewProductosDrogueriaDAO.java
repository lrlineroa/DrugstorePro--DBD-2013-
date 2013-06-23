/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewProductosDrogueria;
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
public class ViewProductosDrogueriaDAO implements Serializable {

    public ViewProductosDrogueriaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewProductosDrogueria viewProductosDrogueria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewProductosDrogueria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewProductosDrogueria(viewProductosDrogueria.getIdProducto()) != null) {
                throw new PreexistingEntityException("ViewProductosDrogueria " + viewProductosDrogueria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewProductosDrogueria viewProductosDrogueria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewProductosDrogueria = em.merge(viewProductosDrogueria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewProductosDrogueria.getIdProducto();
                if (findViewProductosDrogueria(id) == null) {
                    throw new NonexistentEntityException("The viewProductosDrogueria with id " + id + " no longer exists.");
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
            ViewProductosDrogueria viewProductosDrogueria;
            try {
                viewProductosDrogueria = em.getReference(ViewProductosDrogueria.class, id);
                viewProductosDrogueria.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewProductosDrogueria with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewProductosDrogueria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewProductosDrogueria> findViewProductosDrogueriaEntities() {
        return findViewProductosDrogueriaEntities(true, -1, -1);
    }

    public List<ViewProductosDrogueria> findViewProductosDrogueriaEntities(int maxResults, int firstResult) {
        return findViewProductosDrogueriaEntities(false, maxResults, firstResult);
    }

    private List<ViewProductosDrogueria> findViewProductosDrogueriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewProductosDrogueria.class));
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

    public ViewProductosDrogueria findViewProductosDrogueria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewProductosDrogueria.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewProductosDrogueriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewProductosDrogueria> rt = cq.from(ViewProductosDrogueria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
