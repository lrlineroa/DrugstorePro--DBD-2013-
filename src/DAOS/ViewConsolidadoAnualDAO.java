/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewConsolidadoAnual;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author User
 */
public class ViewConsolidadoAnualDAO implements Serializable {

    public ViewConsolidadoAnualDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewConsolidadoAnual viewConsolidadoAnual) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewConsolidadoAnual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewConsolidadoAnual(viewConsolidadoAnual.getIdConsAnual()) != null) {
                throw new PreexistingEntityException("ViewConsolidadoAnual " + viewConsolidadoAnual + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewConsolidadoAnual viewConsolidadoAnual) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewConsolidadoAnual = em.merge(viewConsolidadoAnual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewConsolidadoAnual.getIdConsAnual();
                if (findViewConsolidadoAnual(id) == null) {
                    throw new NonexistentEntityException("The viewConsolidadoAnual with id " + id + " no longer exists.");
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
            ViewConsolidadoAnual viewConsolidadoAnual;
            try {
                viewConsolidadoAnual = em.getReference(ViewConsolidadoAnual.class, id);
                viewConsolidadoAnual.getIdConsAnual();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewConsolidadoAnual with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewConsolidadoAnual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewConsolidadoAnual> findViewConsolidadoAnualEntities() {
        return findViewConsolidadoAnualEntities(true, -1, -1);
    }

    public List<ViewConsolidadoAnual> findViewConsolidadoAnualEntities(int maxResults, int firstResult) {
        return findViewConsolidadoAnualEntities(false, maxResults, firstResult);
    }

    private List<ViewConsolidadoAnual> findViewConsolidadoAnualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewConsolidadoAnual.class));
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

    public ViewConsolidadoAnual findViewConsolidadoAnual(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewConsolidadoAnual.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewConsolidadoAnualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewConsolidadoAnual> rt = cq.from(ViewConsolidadoAnual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<ViewConsolidadoAnual> findAll(){
        EntityManager em=getEntityManager();
        try {
            Query q= em.createNamedQuery("ViewConsolidadoAnual.findAll");
            return q.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
