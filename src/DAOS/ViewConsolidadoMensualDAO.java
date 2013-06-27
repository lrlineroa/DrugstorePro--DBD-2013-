/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewConsolidadoMensual;
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
public class ViewConsolidadoMensualDAO implements Serializable {

    public ViewConsolidadoMensualDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewConsolidadoMensual viewConsolidadoMensual) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewConsolidadoMensual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewConsolidadoMensual(viewConsolidadoMensual.getIdConsMensual()) != null) {
                throw new PreexistingEntityException("ViewConsolidadoMensual " + viewConsolidadoMensual + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewConsolidadoMensual viewConsolidadoMensual) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewConsolidadoMensual = em.merge(viewConsolidadoMensual);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewConsolidadoMensual.getIdConsMensual();
                if (findViewConsolidadoMensual(id) == null) {
                    throw new NonexistentEntityException("The viewConsolidadoMensual with id " + id + " no longer exists.");
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
            ViewConsolidadoMensual viewConsolidadoMensual;
            try {
                viewConsolidadoMensual = em.getReference(ViewConsolidadoMensual.class, id);
                viewConsolidadoMensual.getIdConsMensual();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewConsolidadoMensual with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewConsolidadoMensual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewConsolidadoMensual> findViewConsolidadoMensualEntities() {
        return findViewConsolidadoMensualEntities(true, -1, -1);
    }

    public List<ViewConsolidadoMensual> findViewConsolidadoMensualEntities(int maxResults, int firstResult) {
        return findViewConsolidadoMensualEntities(false, maxResults, firstResult);
    }

    private List<ViewConsolidadoMensual> findViewConsolidadoMensualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewConsolidadoMensual.class));
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

    public ViewConsolidadoMensual findViewConsolidadoMensual(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewConsolidadoMensual.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewConsolidadoMensualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewConsolidadoMensual> rt = cq.from(ViewConsolidadoMensual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<ViewConsolidadoMensual> findViewConsolidadoMensualEntities(int year){
         EntityManager em=getEntityManager();
        try {
                 
            String query="ViewConsolidadoMensual.findByAño";
            
            Query q = em.createNamedQuery(query);
            
                    q.setParameter("año",year);
                    
            
            return q.getResultList();
            
                    
        } catch (NoResultException e) {
            return null;
        }
        
    }
    
}
