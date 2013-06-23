/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Views.ViewUsoMedic;
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
public class ViewUsoMedicDAO implements Serializable {

    public ViewUsoMedicDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ViewUsoMedic viewUsoMedic) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(viewUsoMedic);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findViewUsoMedic(viewUsoMedic.getIdUsoMedicamento()) != null) {
                throw new PreexistingEntityException("ViewUsoMedic " + viewUsoMedic + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ViewUsoMedic viewUsoMedic) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            viewUsoMedic = em.merge(viewUsoMedic);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = viewUsoMedic.getIdUsoMedicamento();
                if (findViewUsoMedic(id) == null) {
                    throw new NonexistentEntityException("The viewUsoMedic with id " + id + " no longer exists.");
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
            ViewUsoMedic viewUsoMedic;
            try {
                viewUsoMedic = em.getReference(ViewUsoMedic.class, id);
                viewUsoMedic.getIdUsoMedicamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The viewUsoMedic with id " + id + " no longer exists.", enfe);
            }
            em.remove(viewUsoMedic);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ViewUsoMedic> findViewUsoMedicEntities() {
        return findViewUsoMedicEntities(true, -1, -1);
    }

    public List<ViewUsoMedic> findViewUsoMedicEntities(int maxResults, int firstResult) {
        return findViewUsoMedicEntities(false, maxResults, firstResult);
    }

    private List<ViewUsoMedic> findViewUsoMedicEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ViewUsoMedic.class));
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

    public ViewUsoMedic findViewUsoMedic(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ViewUsoMedic.class, id);
        } finally {
            em.close();
        }
    }

    public int getViewUsoMedicCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ViewUsoMedic> rt = cq.from(ViewUsoMedic.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
