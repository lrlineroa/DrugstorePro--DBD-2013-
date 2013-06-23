/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewMedicamento;
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
public class ViewMedicamentoDAO implements Serializable {

    public ViewMedicamentoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewMedicamento viewMedicamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewMedicamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewMedicamento(viewMedicamento.getIdProducto()) != null) {
                throw new PreexistingEntityException("ViewMedicamento " + viewMedicamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewMedicamento viewMedicamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewMedicamento = em.merge(viewMedicamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewMedicamento.getIdProducto();
                if (findViewMedicamento(id) == null) {
                    throw new NonexistentEntityException("The viewMedicamento with id " + id + " no longer exists.");
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
            ViewMedicamento viewMedicamento;
            try {
                viewMedicamento = em.getReference(ViewMedicamento.class, id);
                viewMedicamento.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewMedicamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewMedicamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewMedicamento> findViewMedicamentoEntities() {
        return findViewMedicamentoEntities(true, -1, -1);
    }

    public List<ViewMedicamento> findViewMedicamentoEntities(int maxResults, int firstResult) {
        return findViewMedicamentoEntities(false, maxResults, firstResult);
    }

    private List<ViewMedicamento> findViewMedicamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewMedicamento.class));
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

    public ViewMedicamento findViewMedicamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewMedicamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewMedicamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewMedicamento> rt = cq.from(ViewMedicamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
