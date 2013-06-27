/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewConsolidadoSemanal;
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
public class ViewConsolidadoSemanalDAO implements Serializable {

    public ViewConsolidadoSemanalDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewConsolidadoSemanal viewConsolidadoSemanal) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewConsolidadoSemanal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewConsolidadoSemanal(viewConsolidadoSemanal.getIdConsSemanal()) != null) {
                throw new PreexistingEntityException("ViewConsolidadoSemanal " + viewConsolidadoSemanal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewConsolidadoSemanal viewConsolidadoSemanal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewConsolidadoSemanal = em.merge(viewConsolidadoSemanal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewConsolidadoSemanal.getIdConsSemanal();
                if (findViewConsolidadoSemanal(id) == null) {
                    throw new NonexistentEntityException("The viewConsolidadoSemanal with id " + id + " no longer exists.");
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
            ViewConsolidadoSemanal viewConsolidadoSemanal;
            try {
                viewConsolidadoSemanal = em.getReference(ViewConsolidadoSemanal.class, id);
                viewConsolidadoSemanal.getIdConsSemanal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewConsolidadoSemanal with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewConsolidadoSemanal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewConsolidadoSemanal> findViewConsolidadoSemanalEntities() {
        return findViewConsolidadoSemanalEntities(true, -1, -1);
    }

    public List<ViewConsolidadoSemanal> findViewConsolidadoSemanalEntities(int maxResults, int firstResult) {
        return findViewConsolidadoSemanalEntities(false, maxResults, firstResult);
    }

    private List<ViewConsolidadoSemanal> findViewConsolidadoSemanalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewConsolidadoSemanal.class));
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

    public ViewConsolidadoSemanal findViewConsolidadoSemanal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewConsolidadoSemanal.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewConsolidadoSemanalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewConsolidadoSemanal> rt = cq.from(ViewConsolidadoSemanal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
