/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.DataBaseException;
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
            if (findViewMedicamentoById(viewMedicamento.getIdProducto()) != null) {
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
                if (findViewMedicamentoById(id) == null) {
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

    public ViewMedicamento findViewMedicamentoById(Integer id) {
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
    
    //this method returns a list of products such name is like the given.
    public List<ViewMedicamento> findViewMedicamentoListByName(String name) {
        Query q = getEntityManager().createNamedQuery("ViewMedicamento.findByNombreProducto").setParameter("nombreProducto", name);
        try {
            return q.getResultList();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("datos no encontrados");
            return null;
        }
    }
    // this method returns a specific  product with a ID a name given

    public ViewMedicamento findViewMedicamentoByIdAndName(Integer ID, String name) {
        EntityManager em = getEntityManager();
        EntityManager em2 = getEntityManager();
        Query q = em.createNamedQuery("ViewMedicamento.findByIdNombreProducto").
                setParameter("nombreProducto", name).setParameter("idProducto", ID);
        q.setParameter("idProducto", ID);
        q.setParameter("nombreProducto", name);
        try {
            em2.getTransaction().begin();
            em2.flush();
            em2.getTransaction().commit();
            return (ViewMedicamento) q.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.println("datos no encontrados");
            return null;
        }
    }

    //this method increases or decreases  the amount in the inventary of a specific product
    //if sum equals true the amount incremets, if false decreases
    public int Update(Integer ID, int amount, boolean isInventary) throws DataBaseException {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
//        Integer find;
        Integer succes = 0;
        try {
            if (isInventary) {
                Query q = em.createNamedQuery("ViewMedicamento.hacerInventario");
                q.setParameter("id", ID).setParameter("amount", new Integer(amount));
                int updateCount = q.executeUpdate();
                em.getTransaction().commit();
                return updateCount;
            } else {
//                if (!((find - amount) < 0)) {
                
                Query q = em.createNamedQuery("ViewMedicamento.hacerVenta");
                q.setParameter("id", ID).setParameter("amount", new Integer(amount)).setParameter("succes", succes);
                succes = (Integer) q.getSingleResult();
                em.getTransaction().commit();
                if (succes == 0){
                    throw (new DataBaseException("No hay prodcutos suficientes en inventario."));
                }
                return succes;
//                } else {
//                    return -1;
//                }
            }
        } catch (Exception evt) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw (new DataBaseException(evt.getMessage(), evt));
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
}
