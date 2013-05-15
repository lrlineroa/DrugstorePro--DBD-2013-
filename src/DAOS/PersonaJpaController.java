/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.IllegalOrphanException;
import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Drogueria;
import Entities.Cargo;
import Entities.Invetariorpt;
import java.util.ArrayList;
import java.util.List;
import Entities.Factura;
import Entities.Logs;
import Entities.Persona;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class PersonaJpaController implements Serializable {

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) throws PreexistingEntityException, Exception {
        if (persona.getInvetariorptList() == null) {
            persona.setInvetariorptList(new ArrayList<Invetariorpt>());
        }
        if (persona.getFacturaList() == null) {
            persona.setFacturaList(new ArrayList<Factura>());
        }
        if (persona.getLogsList() == null) {
            persona.setLogsList(new ArrayList<Logs>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Drogueria idDrogueria = persona.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria = em.getReference(idDrogueria.getClass(), idDrogueria.getIdDrogueria());
                persona.setIdDrogueria(idDrogueria);
            }
            Cargo idCargo = persona.getIdCargo();
            if (idCargo != null) {
                idCargo = em.getReference(idCargo.getClass(), idCargo.getIdCargo());
                persona.setIdCargo(idCargo);
            }
            List<Invetariorpt> attachedInvetariorptList = new ArrayList<Invetariorpt>();
            for (Invetariorpt invetariorptListInvetariorptToAttach : persona.getInvetariorptList()) {
                invetariorptListInvetariorptToAttach = em.getReference(invetariorptListInvetariorptToAttach.getClass(), invetariorptListInvetariorptToAttach.getIdInventariorpt());
                attachedInvetariorptList.add(invetariorptListInvetariorptToAttach);
            }
            persona.setInvetariorptList(attachedInvetariorptList);
            List<Factura> attachedFacturaList = new ArrayList<Factura>();
            for (Factura facturaListFacturaToAttach : persona.getFacturaList()) {
                facturaListFacturaToAttach = em.getReference(facturaListFacturaToAttach.getClass(), facturaListFacturaToAttach.getIdFactura());
                attachedFacturaList.add(facturaListFacturaToAttach);
            }
            persona.setFacturaList(attachedFacturaList);
            List<Logs> attachedLogsList = new ArrayList<Logs>();
            for (Logs logsListLogsToAttach : persona.getLogsList()) {
                logsListLogsToAttach = em.getReference(logsListLogsToAttach.getClass(), logsListLogsToAttach.getIdLog());
                attachedLogsList.add(logsListLogsToAttach);
            }
            persona.setLogsList(attachedLogsList);
            em.persist(persona);
            if (idDrogueria != null) {
                idDrogueria.getPersonaList().add(persona);
                idDrogueria = em.merge(idDrogueria);
            }
            if (idCargo != null) {
                idCargo.getPersonaList().add(persona);
                idCargo = em.merge(idCargo);
            }
            for (Invetariorpt invetariorptListInvetariorpt : persona.getInvetariorptList()) {
                Persona oldIdPersonaOfInvetariorptListInvetariorpt = invetariorptListInvetariorpt.getIdPersona();
                invetariorptListInvetariorpt.setIdPersona(persona);
                invetariorptListInvetariorpt = em.merge(invetariorptListInvetariorpt);
                if (oldIdPersonaOfInvetariorptListInvetariorpt != null) {
                    oldIdPersonaOfInvetariorptListInvetariorpt.getInvetariorptList().remove(invetariorptListInvetariorpt);
                    oldIdPersonaOfInvetariorptListInvetariorpt = em.merge(oldIdPersonaOfInvetariorptListInvetariorpt);
                }
            }
            for (Factura facturaListFactura : persona.getFacturaList()) {
                Persona oldIdPersonaOfFacturaListFactura = facturaListFactura.getIdPersona();
                facturaListFactura.setIdPersona(persona);
                facturaListFactura = em.merge(facturaListFactura);
                if (oldIdPersonaOfFacturaListFactura != null) {
                    oldIdPersonaOfFacturaListFactura.getFacturaList().remove(facturaListFactura);
                    oldIdPersonaOfFacturaListFactura = em.merge(oldIdPersonaOfFacturaListFactura);
                }
            }
            for (Logs logsListLogs : persona.getLogsList()) {
                Persona oldIdPersonaOfLogsListLogs = logsListLogs.getIdPersona();
                logsListLogs.setIdPersona(persona);
                logsListLogs = em.merge(logsListLogs);
                if (oldIdPersonaOfLogsListLogs != null) {
                    oldIdPersonaOfLogsListLogs.getLogsList().remove(logsListLogs);
                    oldIdPersonaOfLogsListLogs = em.merge(oldIdPersonaOfLogsListLogs);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersona(persona.getIdPersona()) != null) {
                throw new PreexistingEntityException("Persona " + persona + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getIdPersona());
            Drogueria idDrogueriaOld = persistentPersona.getIdDrogueria();
            Drogueria idDrogueriaNew = persona.getIdDrogueria();
            Cargo idCargoOld = persistentPersona.getIdCargo();
            Cargo idCargoNew = persona.getIdCargo();
            List<Invetariorpt> invetariorptListOld = persistentPersona.getInvetariorptList();
            List<Invetariorpt> invetariorptListNew = persona.getInvetariorptList();
            List<Factura> facturaListOld = persistentPersona.getFacturaList();
            List<Factura> facturaListNew = persona.getFacturaList();
            List<Logs> logsListOld = persistentPersona.getLogsList();
            List<Logs> logsListNew = persona.getLogsList();
            List<String> illegalOrphanMessages = null;
            for (Invetariorpt invetariorptListOldInvetariorpt : invetariorptListOld) {
                if (!invetariorptListNew.contains(invetariorptListOldInvetariorpt)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Invetariorpt " + invetariorptListOldInvetariorpt + " since its idPersona field is not nullable.");
                }
            }
            for (Factura facturaListOldFactura : facturaListOld) {
                if (!facturaListNew.contains(facturaListOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaListOldFactura + " since its idPersona field is not nullable.");
                }
            }
            for (Logs logsListOldLogs : logsListOld) {
                if (!logsListNew.contains(logsListOldLogs)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Logs " + logsListOldLogs + " since its idPersona field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idDrogueriaNew != null) {
                idDrogueriaNew = em.getReference(idDrogueriaNew.getClass(), idDrogueriaNew.getIdDrogueria());
                persona.setIdDrogueria(idDrogueriaNew);
            }
            if (idCargoNew != null) {
                idCargoNew = em.getReference(idCargoNew.getClass(), idCargoNew.getIdCargo());
                persona.setIdCargo(idCargoNew);
            }
            List<Invetariorpt> attachedInvetariorptListNew = new ArrayList<Invetariorpt>();
            for (Invetariorpt invetariorptListNewInvetariorptToAttach : invetariorptListNew) {
                invetariorptListNewInvetariorptToAttach = em.getReference(invetariorptListNewInvetariorptToAttach.getClass(), invetariorptListNewInvetariorptToAttach.getIdInventariorpt());
                attachedInvetariorptListNew.add(invetariorptListNewInvetariorptToAttach);
            }
            invetariorptListNew = attachedInvetariorptListNew;
            persona.setInvetariorptList(invetariorptListNew);
            List<Factura> attachedFacturaListNew = new ArrayList<Factura>();
            for (Factura facturaListNewFacturaToAttach : facturaListNew) {
                facturaListNewFacturaToAttach = em.getReference(facturaListNewFacturaToAttach.getClass(), facturaListNewFacturaToAttach.getIdFactura());
                attachedFacturaListNew.add(facturaListNewFacturaToAttach);
            }
            facturaListNew = attachedFacturaListNew;
            persona.setFacturaList(facturaListNew);
            List<Logs> attachedLogsListNew = new ArrayList<Logs>();
            for (Logs logsListNewLogsToAttach : logsListNew) {
                logsListNewLogsToAttach = em.getReference(logsListNewLogsToAttach.getClass(), logsListNewLogsToAttach.getIdLog());
                attachedLogsListNew.add(logsListNewLogsToAttach);
            }
            logsListNew = attachedLogsListNew;
            persona.setLogsList(logsListNew);
            persona = em.merge(persona);
            if (idDrogueriaOld != null && !idDrogueriaOld.equals(idDrogueriaNew)) {
                idDrogueriaOld.getPersonaList().remove(persona);
                idDrogueriaOld = em.merge(idDrogueriaOld);
            }
            if (idDrogueriaNew != null && !idDrogueriaNew.equals(idDrogueriaOld)) {
                idDrogueriaNew.getPersonaList().add(persona);
                idDrogueriaNew = em.merge(idDrogueriaNew);
            }
            if (idCargoOld != null && !idCargoOld.equals(idCargoNew)) {
                idCargoOld.getPersonaList().remove(persona);
                idCargoOld = em.merge(idCargoOld);
            }
            if (idCargoNew != null && !idCargoNew.equals(idCargoOld)) {
                idCargoNew.getPersonaList().add(persona);
                idCargoNew = em.merge(idCargoNew);
            }
            for (Invetariorpt invetariorptListNewInvetariorpt : invetariorptListNew) {
                if (!invetariorptListOld.contains(invetariorptListNewInvetariorpt)) {
                    Persona oldIdPersonaOfInvetariorptListNewInvetariorpt = invetariorptListNewInvetariorpt.getIdPersona();
                    invetariorptListNewInvetariorpt.setIdPersona(persona);
                    invetariorptListNewInvetariorpt = em.merge(invetariorptListNewInvetariorpt);
                    if (oldIdPersonaOfInvetariorptListNewInvetariorpt != null && !oldIdPersonaOfInvetariorptListNewInvetariorpt.equals(persona)) {
                        oldIdPersonaOfInvetariorptListNewInvetariorpt.getInvetariorptList().remove(invetariorptListNewInvetariorpt);
                        oldIdPersonaOfInvetariorptListNewInvetariorpt = em.merge(oldIdPersonaOfInvetariorptListNewInvetariorpt);
                    }
                }
            }
            for (Factura facturaListNewFactura : facturaListNew) {
                if (!facturaListOld.contains(facturaListNewFactura)) {
                    Persona oldIdPersonaOfFacturaListNewFactura = facturaListNewFactura.getIdPersona();
                    facturaListNewFactura.setIdPersona(persona);
                    facturaListNewFactura = em.merge(facturaListNewFactura);
                    if (oldIdPersonaOfFacturaListNewFactura != null && !oldIdPersonaOfFacturaListNewFactura.equals(persona)) {
                        oldIdPersonaOfFacturaListNewFactura.getFacturaList().remove(facturaListNewFactura);
                        oldIdPersonaOfFacturaListNewFactura = em.merge(oldIdPersonaOfFacturaListNewFactura);
                    }
                }
            }
            for (Logs logsListNewLogs : logsListNew) {
                if (!logsListOld.contains(logsListNewLogs)) {
                    Persona oldIdPersonaOfLogsListNewLogs = logsListNewLogs.getIdPersona();
                    logsListNewLogs.setIdPersona(persona);
                    logsListNewLogs = em.merge(logsListNewLogs);
                    if (oldIdPersonaOfLogsListNewLogs != null && !oldIdPersonaOfLogsListNewLogs.equals(persona)) {
                        oldIdPersonaOfLogsListNewLogs.getLogsList().remove(logsListNewLogs);
                        oldIdPersonaOfLogsListNewLogs = em.merge(oldIdPersonaOfLogsListNewLogs);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = persona.getIdPersona();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Invetariorpt> invetariorptListOrphanCheck = persona.getInvetariorptList();
            for (Invetariorpt invetariorptListOrphanCheckInvetariorpt : invetariorptListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Invetariorpt " + invetariorptListOrphanCheckInvetariorpt + " in its invetariorptList field has a non-nullable idPersona field.");
            }
            List<Factura> facturaListOrphanCheck = persona.getFacturaList();
            for (Factura facturaListOrphanCheckFactura : facturaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Factura " + facturaListOrphanCheckFactura + " in its facturaList field has a non-nullable idPersona field.");
            }
            List<Logs> logsListOrphanCheck = persona.getLogsList();
            for (Logs logsListOrphanCheckLogs : logsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Logs " + logsListOrphanCheckLogs + " in its logsList field has a non-nullable idPersona field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Drogueria idDrogueria = persona.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria.getPersonaList().remove(persona);
                idDrogueria = em.merge(idDrogueria);
            }
            Cargo idCargo = persona.getIdCargo();
            if (idCargo != null) {
                idCargo.getPersonaList().remove(persona);
                idCargo = em.merge(idCargo);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
