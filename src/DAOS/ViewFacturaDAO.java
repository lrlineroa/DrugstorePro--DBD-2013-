/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewFactura;
import Entities.Views.ViewPersona;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 *
 * @author User
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
            em.persist(viewFactura);
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
            viewFactura = em.merge(viewFactura);
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

    public List findTotalSalesForMonth(Integer year) {
        EntityManager em=getEntityManager();
        try {
                 
            String query="Select FUNC('MONTH',vf.fechaFactura) ,SUM(vf.total) from ViewFactura vf "
                    + "where FUNC('YEAR',vf.fechaFactura)=:year group by FUNC('MONTH',vf.fechaFactura)";
            
            Query q = em.createQuery(query);
            
                    q.setParameter("year",year);
            
            return q.getResultList();
            
                    
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List findTotalSalesForYear(Integer yearInit,Integer yearEnd) {
        EntityManager em=getEntityManager();
        try {
                 
            String query="Select FUNC('YEAR',vf.fechaFactura) ,SUM(vf.total) from ViewFactura vf "
                    + "where FUNC('YEAR',vf.fechaFactura)>=:yearInit AND FUNC('YEAR',vf.fechaFactura)<=:yearEnd "
                    + "GROUP BY FUNC('YEAR',vf.fechaFactura)";
            
            Query q = em.createQuery(query);
            
                    q.setParameter("yearInit",yearInit);
                    q.setParameter("yearEnd",yearEnd);
            
            return q.getResultList();
            
                    
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Integer findSalesForWeek(Date dayInitWeek,Date dayEndWeek){
        EntityManager em=getEntityManager();
        try {
                 
            String query="Select SUM(vf.total) from ViewFactura vf "
                    + "where vf.fechaFactura >=:dayInit AND vf.fechaFactura<=:dayEnd";
            
            Query q = em.createQuery(query);
            
                   
                    q.setParameter("dayInit", dayInitWeek);
                    q.setParameter("dayEnd", dayEndWeek);
            
            return (Integer) q.getSingleResult();
            
                    
        } catch (NoResultException e) {
            return null;
        }
    }
}
