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
import Entities.Views.ViewFactura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Edward
 */
public class ViewFacturaDAO implements Serializable {

    public ViewFacturaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewFactura viewFactura) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona idPersona = viewFactura.getIdPersona();
            if (idPersona != null) {
                idPersona = em.getReference(idPersona.getClass(), idPersona.getIdPersona());
                viewFactura.setIdPersona(idPersona);
            }
            em.persist(viewFactura);
            if (idPersona != null) {
                idPersona.getViewFacturaList().add(viewFactura);
                idPersona = em.merge(idPersona);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewFactura(viewFactura.getIdFactura()) != null) {
                throw new PreexistingEntityException("ViewFactura " + viewFactura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewFactura viewFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewFactura persistentViewFactura = em.find(ViewFactura.class, viewFactura.getIdFactura());
            Persona idPersonaOld = persistentViewFactura.getIdPersona();
            Persona idPersonaNew = viewFactura.getIdPersona();
            if (idPersonaNew != null) {
                idPersonaNew = em.getReference(idPersonaNew.getClass(), idPersonaNew.getIdPersona());
                viewFactura.setIdPersona(idPersonaNew);
            }
            viewFactura = em.merge(viewFactura);
            if (idPersonaOld != null && !idPersonaOld.equals(idPersonaNew)) {
                idPersonaOld.getViewFacturaList().remove(viewFactura);
                idPersonaOld = em.merge(idPersonaOld);
            }
            if (idPersonaNew != null && !idPersonaNew.equals(idPersonaOld)) {
                idPersonaNew.getViewFacturaList().add(viewFactura);
                idPersonaNew = em.merge(idPersonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewFactura.getIdFactura();
                if (findViewFactura(id) == null) {
                    throw new NonexistentEntityException("The viewFactura with id " + id + " no longer exists.");
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
            ViewFactura viewFactura;
            try {
                viewFactura = em.getReference(ViewFactura.class, id);
                viewFactura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewFactura with id " + id + " no longer exists.", enfe);
            }
            Persona idPersona = viewFactura.getIdPersona();
            if (idPersona != null) {
                idPersona.getViewFacturaList().remove(viewFactura);
                idPersona = em.merge(idPersona);
            }
            em.remove(viewFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewFactura> findViewFacturaEntities() {
        return findViewFacturaEntities(true, -1, -1);
    }

    public List<ViewFactura> findViewFacturaEntities(int maxResults, int firstResult) {
        return findViewFacturaEntities(false, maxResults, firstResult);
    }

    private List<ViewFactura> findViewFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewFactura.class));
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

    public ViewFactura findViewFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewFactura> rt = cq.from(ViewFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
