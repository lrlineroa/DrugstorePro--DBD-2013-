/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.IllegalOrphanException;
import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Drogueria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entities.Medicamento;
import java.util.ArrayList;
import java.util.List;
import Entities.Persona;
import Entities.Pedido;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class DrogueriaJpaController implements Serializable {

    public DrogueriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Drogueria drogueria) throws PreexistingEntityException, Exception {
        if (drogueria.getMedicamentoList() == null) {
            drogueria.setMedicamentoList(new ArrayList<Medicamento>());
        }
        if (drogueria.getPersonaList() == null) {
            drogueria.setPersonaList(new ArrayList<Persona>());
        }
        if (drogueria.getPedidoList() == null) {
            drogueria.setPedidoList(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : drogueria.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            drogueria.setMedicamentoList(attachedMedicamentoList);
            List<Persona> attachedPersonaList = new ArrayList<Persona>();
            for (Persona personaListPersonaToAttach : drogueria.getPersonaList()) {
                personaListPersonaToAttach = em.getReference(personaListPersonaToAttach.getClass(), personaListPersonaToAttach.getIdPersona());
                attachedPersonaList.add(personaListPersonaToAttach);
            }
            drogueria.setPersonaList(attachedPersonaList);
            List<Pedido> attachedPedidoList = new ArrayList<Pedido>();
            for (Pedido pedidoListPedidoToAttach : drogueria.getPedidoList()) {
                pedidoListPedidoToAttach = em.getReference(pedidoListPedidoToAttach.getClass(), pedidoListPedidoToAttach.getIdPedido());
                attachedPedidoList.add(pedidoListPedidoToAttach);
            }
            drogueria.setPedidoList(attachedPedidoList);
            em.persist(drogueria);
            for (Medicamento medicamentoListMedicamento : drogueria.getMedicamentoList()) {
                medicamentoListMedicamento.getDrogueriaList().add(drogueria);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            for (Persona personaListPersona : drogueria.getPersonaList()) {
                Drogueria oldIdDrogueriaOfPersonaListPersona = personaListPersona.getIdDrogueria();
                personaListPersona.setIdDrogueria(drogueria);
                personaListPersona = em.merge(personaListPersona);
                if (oldIdDrogueriaOfPersonaListPersona != null) {
                    oldIdDrogueriaOfPersonaListPersona.getPersonaList().remove(personaListPersona);
                    oldIdDrogueriaOfPersonaListPersona = em.merge(oldIdDrogueriaOfPersonaListPersona);
                }
            }
            for (Pedido pedidoListPedido : drogueria.getPedidoList()) {
                Drogueria oldIdDrogueriaOfPedidoListPedido = pedidoListPedido.getIdDrogueria();
                pedidoListPedido.setIdDrogueria(drogueria);
                pedidoListPedido = em.merge(pedidoListPedido);
                if (oldIdDrogueriaOfPedidoListPedido != null) {
                    oldIdDrogueriaOfPedidoListPedido.getPedidoList().remove(pedidoListPedido);
                    oldIdDrogueriaOfPedidoListPedido = em.merge(oldIdDrogueriaOfPedidoListPedido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDrogueria(drogueria.getIdDrogueria()) != null) {
                throw new PreexistingEntityException("Drogueria " + drogueria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Drogueria drogueria) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Drogueria persistentDrogueria = em.find(Drogueria.class, drogueria.getIdDrogueria());
            List<Medicamento> medicamentoListOld = persistentDrogueria.getMedicamentoList();
            List<Medicamento> medicamentoListNew = drogueria.getMedicamentoList();
            List<Persona> personaListOld = persistentDrogueria.getPersonaList();
            List<Persona> personaListNew = drogueria.getPersonaList();
            List<Pedido> pedidoListOld = persistentDrogueria.getPedidoList();
            List<Pedido> pedidoListNew = drogueria.getPedidoList();
            List<String> illegalOrphanMessages = null;
            for (Persona personaListOldPersona : personaListOld) {
                if (!personaListNew.contains(personaListOldPersona)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Persona " + personaListOldPersona + " since its idDrogueria field is not nullable.");
                }
            }
            for (Pedido pedidoListOldPedido : pedidoListOld) {
                if (!pedidoListNew.contains(pedidoListOldPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedido " + pedidoListOldPedido + " since its idDrogueria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Medicamento> attachedMedicamentoListNew = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListNewMedicamentoToAttach : medicamentoListNew) {
                medicamentoListNewMedicamentoToAttach = em.getReference(medicamentoListNewMedicamentoToAttach.getClass(), medicamentoListNewMedicamentoToAttach.getIdProducto());
                attachedMedicamentoListNew.add(medicamentoListNewMedicamentoToAttach);
            }
            medicamentoListNew = attachedMedicamentoListNew;
            drogueria.setMedicamentoList(medicamentoListNew);
            List<Persona> attachedPersonaListNew = new ArrayList<Persona>();
            for (Persona personaListNewPersonaToAttach : personaListNew) {
                personaListNewPersonaToAttach = em.getReference(personaListNewPersonaToAttach.getClass(), personaListNewPersonaToAttach.getIdPersona());
                attachedPersonaListNew.add(personaListNewPersonaToAttach);
            }
            personaListNew = attachedPersonaListNew;
            drogueria.setPersonaList(personaListNew);
            List<Pedido> attachedPedidoListNew = new ArrayList<Pedido>();
            for (Pedido pedidoListNewPedidoToAttach : pedidoListNew) {
                pedidoListNewPedidoToAttach = em.getReference(pedidoListNewPedidoToAttach.getClass(), pedidoListNewPedidoToAttach.getIdPedido());
                attachedPedidoListNew.add(pedidoListNewPedidoToAttach);
            }
            pedidoListNew = attachedPedidoListNew;
            drogueria.setPedidoList(pedidoListNew);
            drogueria = em.merge(drogueria);
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    medicamentoListOldMedicamento.getDrogueriaList().remove(drogueria);
                    medicamentoListOldMedicamento = em.merge(medicamentoListOldMedicamento);
                }
            }
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    medicamentoListNewMedicamento.getDrogueriaList().add(drogueria);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                }
            }
            for (Persona personaListNewPersona : personaListNew) {
                if (!personaListOld.contains(personaListNewPersona)) {
                    Drogueria oldIdDrogueriaOfPersonaListNewPersona = personaListNewPersona.getIdDrogueria();
                    personaListNewPersona.setIdDrogueria(drogueria);
                    personaListNewPersona = em.merge(personaListNewPersona);
                    if (oldIdDrogueriaOfPersonaListNewPersona != null && !oldIdDrogueriaOfPersonaListNewPersona.equals(drogueria)) {
                        oldIdDrogueriaOfPersonaListNewPersona.getPersonaList().remove(personaListNewPersona);
                        oldIdDrogueriaOfPersonaListNewPersona = em.merge(oldIdDrogueriaOfPersonaListNewPersona);
                    }
                }
            }
            for (Pedido pedidoListNewPedido : pedidoListNew) {
                if (!pedidoListOld.contains(pedidoListNewPedido)) {
                    Drogueria oldIdDrogueriaOfPedidoListNewPedido = pedidoListNewPedido.getIdDrogueria();
                    pedidoListNewPedido.setIdDrogueria(drogueria);
                    pedidoListNewPedido = em.merge(pedidoListNewPedido);
                    if (oldIdDrogueriaOfPedidoListNewPedido != null && !oldIdDrogueriaOfPedidoListNewPedido.equals(drogueria)) {
                        oldIdDrogueriaOfPedidoListNewPedido.getPedidoList().remove(pedidoListNewPedido);
                        oldIdDrogueriaOfPedidoListNewPedido = em.merge(oldIdDrogueriaOfPedidoListNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = drogueria.getIdDrogueria();
                if (findDrogueria(id) == null) {
                    throw new NonexistentEntityException("The drogueria with id " + id + " no longer exists.");
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
            Drogueria drogueria;
            try {
                drogueria = em.getReference(Drogueria.class, id);
                drogueria.getIdDrogueria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The drogueria with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Persona> personaListOrphanCheck = drogueria.getPersonaList();
            for (Persona personaListOrphanCheckPersona : personaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Drogueria (" + drogueria + ") cannot be destroyed since the Persona " + personaListOrphanCheckPersona + " in its personaList field has a non-nullable idDrogueria field.");
            }
            List<Pedido> pedidoListOrphanCheck = drogueria.getPedidoList();
            for (Pedido pedidoListOrphanCheckPedido : pedidoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Drogueria (" + drogueria + ") cannot be destroyed since the Pedido " + pedidoListOrphanCheckPedido + " in its pedidoList field has a non-nullable idDrogueria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Medicamento> medicamentoList = drogueria.getMedicamentoList();
            for (Medicamento medicamentoListMedicamento : medicamentoList) {
                medicamentoListMedicamento.getDrogueriaList().remove(drogueria);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            em.remove(drogueria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Drogueria> findDrogueriaEntities() {
        return findDrogueriaEntities(true, -1, -1);
    }

    public List<Drogueria> findDrogueriaEntities(int maxResults, int firstResult) {
        return findDrogueriaEntities(false, maxResults, firstResult);
    }

    private List<Drogueria> findDrogueriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Drogueria.class));
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

    public Drogueria findDrogueria(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Drogueria.class, id);
        } finally {
            em.close();
        }
    }

    public int getDrogueriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Drogueria> rt = cq.from(Drogueria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
