/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewFabricante;
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
 * @author Edward
 */
public class ViewFabricanteDAO implements Serializable {

    public ViewFabricanteDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewFabricante viewFabricante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewFabricante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewFabricante(viewFabricante.getIdFabricante()) != null) {
                throw new PreexistingEntityException("ViewFabricante " + viewFabricante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewFabricante viewFabricante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewFabricante = em.merge(viewFabricante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewFabricante.getIdFabricante();
                if (findViewFabricante(id) == null) {
                    throw new NonexistentEntityException("The viewFabricante with id " + id + " no longer exists.");
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
            ViewFabricante viewFabricante;
            try {
                viewFabricante = em.getReference(ViewFabricante.class, id);
                viewFabricante.getIdFabricante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewFabricante with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewFabricante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewFabricante> findViewFabricanteEntities() {
        return findViewFabricanteEntities(true, -1, -1);
    }

    public List<ViewFabricante> findViewFabricanteEntities(int maxResults, int firstResult) {
        return findViewFabricanteEntities(false, maxResults, firstResult);
    }

    private List<ViewFabricante> findViewFabricanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewFabricante.class));
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

    public ViewFabricante findViewFabricante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewFabricante.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewFabricanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewFabricante> rt = cq.from(ViewFabricante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
