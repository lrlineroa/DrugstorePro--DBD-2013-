/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Invetariorpt;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Persona;
import Entities.Medicamento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class InvetariorptJpaController implements Serializable {

    public InvetariorptJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Invetariorpt invetariorpt) throws PreexistingEntityException, Exception {
        if (invetariorpt.getMedicamentoList() == null) {
            invetariorpt.setMedicamentoList(new ArrayList<Medicamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona idPersona = invetariorpt.getIdPersona();
            if (idPersona != null) {
                idPersona = em.getReference(idPersona.getClass(), idPersona.getIdPersona());
                invetariorpt.setIdPersona(idPersona);
            }
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : invetariorpt.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            invetariorpt.setMedicamentoList(attachedMedicamentoList);
            em.persist(invetariorpt);
            if (idPersona != null) {
                idPersona.getInvetariorptList().add(invetariorpt);
                idPersona = em.merge(idPersona);
            }
            for (Medicamento medicamentoListMedicamento : invetariorpt.getMedicamentoList()) {
                medicamentoListMedicamento.getInvetariorptList().add(invetariorpt);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInvetariorpt(invetariorpt.getIdInventariorpt()) != null) {
                throw new PreexistingEntityException("Invetariorpt " + invetariorpt + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Invetariorpt invetariorpt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Invetariorpt persistentInvetariorpt = em.find(Invetariorpt.class, invetariorpt.getIdInventariorpt());
            Persona idPersonaOld = persistentInvetariorpt.getIdPersona();
            Persona idPersonaNew = invetariorpt.getIdPersona();
            List<Medicamento> medicamentoListOld = persistentInvetariorpt.getMedicamentoList();
            List<Medicamento> medicamentoListNew = invetariorpt.getMedicamentoList();
            if (idPersonaNew != null) {
                idPersonaNew = em.getReference(idPersonaNew.getClass(), idPersonaNew.getIdPersona());
                invetariorpt.setIdPersona(idPersonaNew);
            }
            List<Medicamento> attachedMedicamentoListNew = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListNewMedicamentoToAttach : medicamentoListNew) {
                medicamentoListNewMedicamentoToAttach = em.getReference(medicamentoListNewMedicamentoToAttach.getClass(), medicamentoListNewMedicamentoToAttach.getIdProducto());
                attachedMedicamentoListNew.add(medicamentoListNewMedicamentoToAttach);
            }
            medicamentoListNew = attachedMedicamentoListNew;
            invetariorpt.setMedicamentoList(medicamentoListNew);
            invetariorpt = em.merge(invetariorpt);
            if (idPersonaOld != null && !idPersonaOld.equals(idPersonaNew)) {
                idPersonaOld.getInvetariorptList().remove(invetariorpt);
                idPersonaOld = em.merge(idPersonaOld);
            }
            if (idPersonaNew != null && !idPersonaNew.equals(idPersonaOld)) {
                idPersonaNew.getInvetariorptList().add(invetariorpt);
                idPersonaNew = em.merge(idPersonaNew);
            }
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    medicamentoListOldMedicamento.getInvetariorptList().remove(invetariorpt);
                    medicamentoListOldMedicamento = em.merge(medicamentoListOldMedicamento);
                }
            }
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    medicamentoListNewMedicamento.getInvetariorptList().add(invetariorpt);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = invetariorpt.getIdInventariorpt();
                if (findInvetariorpt(id) == null) {
                    throw new NonexistentEntityException("The invetariorpt with id " + id + " no longer exists.");
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
            Invetariorpt invetariorpt;
            try {
                invetariorpt = em.getReference(Invetariorpt.class, id);
                invetariorpt.getIdInventariorpt();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The invetariorpt with id " + id + " no longer exists.", enfe);
            }
            Persona idPersona = invetariorpt.getIdPersona();
            if (idPersona != null) {
                idPersona.getInvetariorptList().remove(invetariorpt);
                idPersona = em.merge(idPersona);
            }
            List<Medicamento> medicamentoList = invetariorpt.getMedicamentoList();
            for (Medicamento medicamentoListMedicamento : medicamentoList) {
                medicamentoListMedicamento.getInvetariorptList().remove(invetariorpt);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            em.remove(invetariorpt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Invetariorpt> findInvetariorptEntities() {
        return findInvetariorptEntities(true, -1, -1);
    }

    public List<Invetariorpt> findInvetariorptEntities(int maxResults, int firstResult) {
        return findInvetariorptEntities(false, maxResults, firstResult);
    }

    private List<Invetariorpt> findInvetariorptEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Invetariorpt.class));
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

    public Invetariorpt findInvetariorpt(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Invetariorpt.class, id);
        } finally {
            em.close();
        }
    }

    public int getInvetariorptCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Invetariorpt> rt = cq.from(Invetariorpt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
