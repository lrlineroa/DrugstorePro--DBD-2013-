/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.ViewDrogueria;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class ViewDrogueriaDAO implements Serializable {

    public ViewDrogueriaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewDrogueria viewDrogueria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewDrogueria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewDrogueria(viewDrogueria.getIdDrogueria()) != null) {
                throw new PreexistingEntityException("ViewDrogueria " + viewDrogueria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewDrogueria viewDrogueria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewDrogueria = em.merge(viewDrogueria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = viewDrogueria.getIdDrogueria();
                if (findViewDrogueria(id) == null) {
                    throw new NonexistentEntityException("The viewDrogueria with id " + id + " no longer exists.");
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
            ViewDrogueria viewDrogueria;
            try {
                viewDrogueria = em.getReference(ViewDrogueria.class, id);
                viewDrogueria.getIdDrogueria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewDrogueria with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewDrogueria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewDrogueria> findViewDrogueriaEntities() {
        return findViewDrogueriaEntities(true, -1, -1);
    }

    public List<ViewDrogueria> findViewDrogueriaEntities(int maxResults, int firstResult) {
        return findViewDrogueriaEntities(false, maxResults, firstResult);
    }

    private List<ViewDrogueria> findViewDrogueriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewDrogueria.class));
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

    public ViewDrogueria findViewDrogueria(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewDrogueria.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewDrogueriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewDrogueria> rt = cq.from(ViewDrogueria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
