/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.ViewTipoProducto;
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
public class ViewTipoProductoDAO implements Serializable {

    public ViewTipoProductoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewTipoProducto viewTipoProducto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewTipoProducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewTipoProducto(viewTipoProducto.getIdTipoProducto()) != null) {
                throw new PreexistingEntityException("ViewTipoProducto " + viewTipoProducto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewTipoProducto viewTipoProducto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewTipoProducto = em.merge(viewTipoProducto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = viewTipoProducto.getIdTipoProducto();
                if (findViewTipoProducto(id) == null) {
                    throw new NonexistentEntityException("The viewTipoProducto with id " + id + " no longer exists.");
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
            ViewTipoProducto viewTipoProducto;
            try {
                viewTipoProducto = em.getReference(ViewTipoProducto.class, id);
                viewTipoProducto.getIdTipoProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewTipoProducto with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewTipoProducto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewTipoProducto> findViewTipoProductoEntities() {
        return findViewTipoProductoEntities(true, -1, -1);
    }

    public List<ViewTipoProducto> findViewTipoProductoEntities(int maxResults, int firstResult) {
        return findViewTipoProductoEntities(false, maxResults, firstResult);
    }

    private List<ViewTipoProducto> findViewTipoProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewTipoProducto.class));
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

    public ViewTipoProducto findViewTipoProducto(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewTipoProducto.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewTipoProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewTipoProducto> rt = cq.from(ViewTipoProducto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
