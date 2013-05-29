/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.ViewPersona;
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
public class ViewPersonaDAO implements Serializable {

    public ViewPersonaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewPersona viewPersona) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewPersona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewPersona(viewPersona.getIdPersona()) != null) {
                throw new PreexistingEntityException("ViewPersona " + viewPersona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewPersona viewPersona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewPersona = em.merge(viewPersona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = viewPersona.getIdPersona();
                if (findViewPersona(id) == null) {
                    throw new NonexistentEntityException("The viewPersona with id " + id + " no longer exists.");
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
            ViewPersona viewPersona;
            try {
                viewPersona = em.getReference(ViewPersona.class, id);
                viewPersona.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewPersona with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewPersona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewPersona> findViewPersonaEntities() {
        return findViewPersonaEntities(true, -1, -1);
    }

    public List<ViewPersona> findViewPersonaEntities(int maxResults, int firstResult) {
        return findViewPersonaEntities(false, maxResults, firstResult);
    }

    private List<ViewPersona> findViewPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewPersona.class));
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

    public ViewPersona findViewPersona(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewPersona.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewPersona> rt = cq.from(ViewPersona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ViewPersona> findViewPersonaByDrogueria(BigDecimal idDrogueria) {
        return null;
    }
    
}
