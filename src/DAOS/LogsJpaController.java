/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Logs;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Persona;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class LogsJpaController implements Serializable {

    public LogsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Logs logs) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona idPersona = logs.getIdPersona();
            if (idPersona != null) {
                idPersona = em.getReference(idPersona.getClass(), idPersona.getIdPersona());
                logs.setIdPersona(idPersona);
            }
            em.persist(logs);
            if (idPersona != null) {
                idPersona.getLogsList().add(logs);
                idPersona = em.merge(idPersona);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLogs(logs.getIdLog()) != null) {
                throw new PreexistingEntityException("Logs " + logs + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Logs logs) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Logs persistentLogs = em.find(Logs.class, logs.getIdLog());
            Persona idPersonaOld = persistentLogs.getIdPersona();
            Persona idPersonaNew = logs.getIdPersona();
            if (idPersonaNew != null) {
                idPersonaNew = em.getReference(idPersonaNew.getClass(), idPersonaNew.getIdPersona());
                logs.setIdPersona(idPersonaNew);
            }
            logs = em.merge(logs);
            if (idPersonaOld != null && !idPersonaOld.equals(idPersonaNew)) {
                idPersonaOld.getLogsList().remove(logs);
                idPersonaOld = em.merge(idPersonaOld);
            }
            if (idPersonaNew != null && !idPersonaNew.equals(idPersonaOld)) {
                idPersonaNew.getLogsList().add(logs);
                idPersonaNew = em.merge(idPersonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = logs.getIdLog();
                if (findLogs(id) == null) {
                    throw new NonexistentEntityException("The logs with id " + id + " no longer exists.");
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
            Logs logs;
            try {
                logs = em.getReference(Logs.class, id);
                logs.getIdLog();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The logs with id " + id + " no longer exists.", enfe);
            }
            Persona idPersona = logs.getIdPersona();
            if (idPersona != null) {
                idPersona.getLogsList().remove(logs);
                idPersona = em.merge(idPersona);
            }
            em.remove(logs);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Logs> findLogsEntities() {
        return findLogsEntities(true, -1, -1);
    }

    public List<Logs> findLogsEntities(int maxResults, int firstResult) {
        return findLogsEntities(false, maxResults, firstResult);
    }

    private List<Logs> findLogsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Logs.class));
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

    public Logs findLogs(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Logs.class, id);
        } finally {
            em.close();
        }
    }

    public int getLogsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Logs> rt = cq.from(Logs.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
