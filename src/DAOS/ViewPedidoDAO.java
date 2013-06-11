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
import Entities.Drogueria;
import Entities.Views.ViewPedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Edward
 */
public class ViewPedidoDAO implements Serializable {

    public ViewPedidoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewPedido viewPedido) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Drogueria idDrogueria = viewPedido.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria = em.getReference(idDrogueria.getClass(), idDrogueria.getIdDrogueria());
                viewPedido.setIdDrogueria(idDrogueria);
            }
            em.persist(viewPedido);
            if (idDrogueria != null) {
                idDrogueria.getViewPedidoList().add(viewPedido);
                idDrogueria = em.merge(idDrogueria);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewPedidoById(viewPedido.getIdPedido()) != null) {
                throw new PreexistingEntityException("ViewPedido " + viewPedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewPedido viewPedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ViewPedido persistentViewPedido = em.find(ViewPedido.class, viewPedido.getIdPedido());
            Drogueria idDrogueriaOld = persistentViewPedido.getIdDrogueria();
            Drogueria idDrogueriaNew = viewPedido.getIdDrogueria();
            if (idDrogueriaNew != null) {
                idDrogueriaNew = em.getReference(idDrogueriaNew.getClass(), idDrogueriaNew.getIdDrogueria());
                viewPedido.setIdDrogueria(idDrogueriaNew);
            }
            viewPedido = em.merge(viewPedido);
            if (idDrogueriaOld != null && !idDrogueriaOld.equals(idDrogueriaNew)) {
                idDrogueriaOld.getViewPedidoList().remove(viewPedido);
                idDrogueriaOld = em.merge(idDrogueriaOld);
            }
            if (idDrogueriaNew != null && !idDrogueriaNew.equals(idDrogueriaOld)) {
                idDrogueriaNew.getViewPedidoList().add(viewPedido);
                idDrogueriaNew = em.merge(idDrogueriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewPedido.getIdPedido();
                if (findViewPedidoById(id) == null) {
                    throw new NonexistentEntityException("The viewPedido with id " + id + " no longer exists.");
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
            ViewPedido viewPedido;
            try {
                viewPedido = em.getReference(ViewPedido.class, id);
                viewPedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewPedido with id " + id + " no longer exists.", enfe);
            }
            Drogueria idDrogueria = viewPedido.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria.getViewPedidoList().remove(viewPedido);
                idDrogueria = em.merge(idDrogueria);
            }
            em.remove(viewPedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewPedido> findViewPedidoEntities() {
        return findViewPedidoEntities(true, -1, -1);
    }

    public List<ViewPedido> findViewPedidoEntities(int maxResults, int firstResult) {
        return findViewPedidoEntities(false, maxResults, firstResult);
    }

    private List<ViewPedido> findViewPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewPedido.class));
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

    public ViewPedido findViewPedidoById(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewPedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewPedido> rt = cq.from(ViewPedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
