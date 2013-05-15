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
import Entities.Medicamento;
import Entities.UsoMedicamento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class UsoMedicamentoJpaController implements Serializable {

    public UsoMedicamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsoMedicamento usoMedicamento) throws PreexistingEntityException, Exception {
        if (usoMedicamento.getMedicamentoList() == null) {
            usoMedicamento.setMedicamentoList(new ArrayList<Medicamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : usoMedicamento.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            usoMedicamento.setMedicamentoList(attachedMedicamentoList);
            em.persist(usoMedicamento);
            for (Medicamento medicamentoListMedicamento : usoMedicamento.getMedicamentoList()) {
                UsoMedicamento oldIdUsoMedicamentoOfMedicamentoListMedicamento = medicamentoListMedicamento.getIdUsoMedicamento();
                medicamentoListMedicamento.setIdUsoMedicamento(usoMedicamento);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
                if (oldIdUsoMedicamentoOfMedicamentoListMedicamento != null) {
                    oldIdUsoMedicamentoOfMedicamentoListMedicamento.getMedicamentoList().remove(medicamentoListMedicamento);
                    oldIdUsoMedicamentoOfMedicamentoListMedicamento = em.merge(oldIdUsoMedicamentoOfMedicamentoListMedicamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsoMedicamento(usoMedicamento.getIdUsoMedicamento()) != null) {
                throw new PreexistingEntityException("UsoMedicamento " + usoMedicamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsoMedicamento usoMedicamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsoMedicamento persistentUsoMedicamento = em.find(UsoMedicamento.class, usoMedicamento.getIdUsoMedicamento());
            List<Medicamento> medicamentoListOld = persistentUsoMedicamento.getMedicamentoList();
            List<Medicamento> medicamentoListNew = usoMedicamento.getMedicamentoList();
            List<Medicamento> attachedMedicamentoListNew = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListNewMedicamentoToAttach : medicamentoListNew) {
                medicamentoListNewMedicamentoToAttach = em.getReference(medicamentoListNewMedicamentoToAttach.getClass(), medicamentoListNewMedicamentoToAttach.getIdProducto());
                attachedMedicamentoListNew.add(medicamentoListNewMedicamentoToAttach);
            }
            medicamentoListNew = attachedMedicamentoListNew;
            usoMedicamento.setMedicamentoList(medicamentoListNew);
            usoMedicamento = em.merge(usoMedicamento);
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    medicamentoListOldMedicamento.setIdUsoMedicamento(null);
                    medicamentoListOldMedicamento = em.merge(medicamentoListOldMedicamento);
                }
            }
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    UsoMedicamento oldIdUsoMedicamentoOfMedicamentoListNewMedicamento = medicamentoListNewMedicamento.getIdUsoMedicamento();
                    medicamentoListNewMedicamento.setIdUsoMedicamento(usoMedicamento);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                    if (oldIdUsoMedicamentoOfMedicamentoListNewMedicamento != null && !oldIdUsoMedicamentoOfMedicamentoListNewMedicamento.equals(usoMedicamento)) {
                        oldIdUsoMedicamentoOfMedicamentoListNewMedicamento.getMedicamentoList().remove(medicamentoListNewMedicamento);
                        oldIdUsoMedicamentoOfMedicamentoListNewMedicamento = em.merge(oldIdUsoMedicamentoOfMedicamentoListNewMedicamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = usoMedicamento.getIdUsoMedicamento();
                if (findUsoMedicamento(id) == null) {
                    throw new NonexistentEntityException("The usoMedicamento with id " + id + " no longer exists.");
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
            UsoMedicamento usoMedicamento;
            try {
                usoMedicamento = em.getReference(UsoMedicamento.class, id);
                usoMedicamento.getIdUsoMedicamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usoMedicamento with id " + id + " no longer exists.", enfe);
            }
            List<Medicamento> medicamentoList = usoMedicamento.getMedicamentoList();
            for (Medicamento medicamentoListMedicamento : medicamentoList) {
                medicamentoListMedicamento.setIdUsoMedicamento(null);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            em.remove(usoMedicamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsoMedicamento> findUsoMedicamentoEntities() {
        return findUsoMedicamentoEntities(true, -1, -1);
    }

    public List<UsoMedicamento> findUsoMedicamentoEntities(int maxResults, int firstResult) {
        return findUsoMedicamentoEntities(false, maxResults, firstResult);
    }

    private List<UsoMedicamento> findUsoMedicamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsoMedicamento.class));
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

    public UsoMedicamento findUsoMedicamento(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsoMedicamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsoMedicamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsoMedicamento> rt = cq.from(UsoMedicamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
