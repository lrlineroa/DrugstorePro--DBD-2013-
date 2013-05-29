/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.ViewPresentacion;
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
public class ViewPresentacionDAO implements Serializable {

    public ViewPresentacionDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewPresentacion viewPresentacion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewPresentacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewPresentacion(viewPresentacion.getIdPresentacion()) != null) {
                throw new PreexistingEntityException("ViewPresentacion " + viewPresentacion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewPresentacion viewPresentacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewPresentacion = em.merge(viewPresentacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = viewPresentacion.getIdPresentacion();
                if (findViewPresentacion(id) == null) {
                    throw new NonexistentEntityException("The viewPresentacion with id " + id + " no longer exists.");
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
            ViewPresentacion viewPresentacion;
            try {
                viewPresentacion = em.getReference(ViewPresentacion.class, id);
                viewPresentacion.getIdPresentacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewPresentacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewPresentacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewPresentacion> findViewPresentacionEntities() {
        return findViewPresentacionEntities(true, -1, -1);
    }

    public List<ViewPresentacion> findViewPresentacionEntities(int maxResults, int firstResult) {
        return findViewPresentacionEntities(false, maxResults, firstResult);
    }

    private List<ViewPresentacion> findViewPresentacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewPresentacion.class));
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

    public ViewPresentacion findViewPresentacion(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewPresentacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewPresentacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewPresentacion> rt = cq.from(ViewPresentacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
