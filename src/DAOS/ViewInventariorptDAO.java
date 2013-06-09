/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Persona;
import Entities.Views.ViewInventariorpt;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Edward
 */
public class ViewInventariorptDAO implements Serializable {

    public ViewInventariorptDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewInventariorpt viewInventariorpt) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona idPersona = viewInventariorpt.getIdPersona();
            if (idPersona != null) {
                idPersona = em.getReference(idPersona.getClass(), idPersona.getIdPersona());
                viewInventariorpt.setIdPersona(idPersona);
            }
            em.persist(viewInventariorpt);
            if (idPersona != null) {
                idPersona.getViewInventariorptList().add(viewInventariorpt);
                idPersona = em.merge(idPersona);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewInventariorpt(viewInventariorpt.getIdInventariorpt()) != null) {
                throw new PreexistingEntityException("ViewInventariorpt " + viewInventariorpt + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewInventariorpt viewInventariorpt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewInventariorpt persistentViewInventariorpt = em.find(ViewInventariorpt.class, viewInventariorpt.getIdInventariorpt());
            Persona idPersonaOld = persistentViewInventariorpt.getIdPersona();
            Persona idPersonaNew = viewInventariorpt.getIdPersona();
            if (idPersonaNew != null) {
                idPersonaNew = em.getReference(idPersonaNew.getClass(), idPersonaNew.getIdPersona());
                viewInventariorpt.setIdPersona(idPersonaNew);
            }
            viewInventariorpt = em.merge(viewInventariorpt);
            if (idPersonaOld != null && !idPersonaOld.equals(idPersonaNew)) {
                idPersonaOld.getViewInventariorptList().remove(viewInventariorpt);
                idPersonaOld = em.merge(idPersonaOld);
            }
            if (idPersonaNew != null && !idPersonaNew.equals(idPersonaOld)) {
                idPersonaNew.getViewInventariorptList().add(viewInventariorpt);
                idPersonaNew = em.merge(idPersonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewInventariorpt.getIdInventariorpt();
                if (findViewInventariorpt(id) == null) {
                    throw new NonexistentEntityException("The viewInventariorpt with id " + id + " no longer exists.");
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
            ViewInventariorpt viewInventariorpt;
            try {
                viewInventariorpt = em.getReference(ViewInventariorpt.class, id);
                viewInventariorpt.getIdInventariorpt();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewInventariorpt with id " + id + " no longer exists.", enfe);
            }
            Persona idPersona = viewInventariorpt.getIdPersona();
            if (idPersona != null) {
                idPersona.getViewInventariorptList().remove(viewInventariorpt);
                idPersona = em.merge(idPersona);
            }
            em.remove(viewInventariorpt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewInventariorpt> findViewInventariorptEntities() {
        return findViewInventariorptEntities(true, -1, -1);
    }

    public List<ViewInventariorpt> findViewInventariorptEntities(int maxResults, int firstResult) {
        return findViewInventariorptEntities(false, maxResults, firstResult);
    }

    private List<ViewInventariorpt> findViewInventariorptEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewInventariorpt.class));
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

    public ViewInventariorpt findViewInventariorpt(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewInventariorpt.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewInventariorptCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewInventariorpt> rt = cq.from(ViewInventariorpt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
