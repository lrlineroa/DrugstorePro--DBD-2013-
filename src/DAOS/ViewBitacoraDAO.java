/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewBitacora;
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
public class ViewBitacoraDAO implements Serializable {

    public ViewBitacoraDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewBitacora viewBitacora) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewBitacora);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewBitacora(viewBitacora.getIdBitacora()) != null) {
                throw new PreexistingEntityException("ViewBitacora " + viewBitacora + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewBitacora viewBitacora) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewBitacora = em.merge(viewBitacora);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewBitacora.getIdBitacora();
                if (findViewBitacora(id) == null) {
                    throw new NonexistentEntityException("The viewBitacora with id " + id + " no longer exists.");
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
            ViewBitacora viewBitacora;
            try {
                viewBitacora = em.getReference(ViewBitacora.class, id);
                viewBitacora.getIdBitacora();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewBitacora with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewBitacora);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewBitacora> findViewBitacoraEntities() {
        return findViewBitacoraEntities(true, -1, -1);
    }

    public List<ViewBitacora> findViewBitacoraEntities(int maxResults, int firstResult) {
        return findViewBitacoraEntities(false, maxResults, firstResult);
    }

    private List<ViewBitacora> findViewBitacoraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewBitacora.class));
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

    public ViewBitacora findViewBitacora(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewBitacora.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewBitacoraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewBitacora> rt = cq.from(ViewBitacora.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
