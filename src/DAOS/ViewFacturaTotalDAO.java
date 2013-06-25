/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewFacturaTotal;
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
public class ViewFacturaTotalDAO implements Serializable {

    public ViewFacturaTotalDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewFacturaTotal viewFacturaTotal) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewFacturaTotal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewFacturaTotal(viewFacturaTotal.getIdFactura()) != null) {
                throw new PreexistingEntityException("ViewFacturaTotal " + viewFacturaTotal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewFacturaTotal viewFacturaTotal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewFacturaTotal = em.merge(viewFacturaTotal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = viewFacturaTotal.getIdFactura();
                if (findViewFacturaTotal(id) == null) {
                    throw new NonexistentEntityException("The viewFacturaTotal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewFacturaTotal viewFacturaTotal;
            try {
                viewFacturaTotal = em.getReference(ViewFacturaTotal.class, id);
                viewFacturaTotal.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewFacturaTotal with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewFacturaTotal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewFacturaTotal> findViewFacturaTotalEntities() {
        return findViewFacturaTotalEntities(true, -1, -1);
    }

    public List<ViewFacturaTotal> findViewFacturaTotalEntities(int maxResults, int firstResult) {
        return findViewFacturaTotalEntities(false, maxResults, firstResult);
    }

    private List<ViewFacturaTotal> findViewFacturaTotalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewFacturaTotal.class));
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

    public ViewFacturaTotal findViewFacturaTotal(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewFacturaTotal.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewFacturaTotalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewFacturaTotal> rt = cq.from(ViewFacturaTotal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<ViewFacturaTotal> findFacturaTotalListByIdFactura(Integer idFactura) {
        Query q = getEntityManager().createNamedQuery("ViewFacturaTotal.findByIdFactura").setParameter("idFactura", idFactura);
        try {
            return q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("datos no encontrados");
            return null;
        }
    }  
}
