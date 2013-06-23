/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewAdvice;
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
public class ViewAdviceDAO implements Serializable {

    public ViewAdviceDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewAdvice viewAdvice) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewAdvice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewAdvice(viewAdvice.getIdAdvice()) != null) {
                throw new PreexistingEntityException("ViewAdvice " + viewAdvice + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewAdvice viewAdvice) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewAdvice = em.merge(viewAdvice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewAdvice.getIdAdvice();
                if (findViewAdvice(id) == null) {
                    throw new NonexistentEntityException("The viewAdvice with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewAdvice viewAdvice;
            try {
                viewAdvice = em.getReference(ViewAdvice.class, id);
                viewAdvice.getIdAdvice();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewAdvice with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewAdvice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewAdvice> findViewAdviceEntities() {
        return findViewAdviceEntities(true, -1, -1);
    }

    public List<ViewAdvice> findViewAdviceEntities(int maxResults, int firstResult) {
        return findViewAdviceEntities(false, maxResults, firstResult);
    }

    private List<ViewAdvice> findViewAdviceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewAdvice.class));
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

    public ViewAdvice findViewAdvice(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewAdvice.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewAdviceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewAdvice> rt = cq.from(ViewAdvice.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
