/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entities.Fabricante;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class FabricanteJpaController implements Serializable {

    public FabricanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fabricante fabricante) throws PreexistingEntityException, Exception {
        if (fabricante.getMedicamentoList() == null) {
            fabricante.setMedicamentoList(new ArrayList<Medicamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : fabricante.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            fabricante.setMedicamentoList(attachedMedicamentoList);
            em.persist(fabricante);
            for (Medicamento medicamentoListMedicamento : fabricante.getMedicamentoList()) {
                Fabricante oldFabIdFabricanteOfMedicamentoListMedicamento = medicamentoListMedicamento.getFabIdFabricante();
                medicamentoListMedicamento.setFabIdFabricante(fabricante);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
                if (oldFabIdFabricanteOfMedicamentoListMedicamento != null) {
                    oldFabIdFabricanteOfMedicamentoListMedicamento.getMedicamentoList().remove(medicamentoListMedicamento);
                    oldFabIdFabricanteOfMedicamentoListMedicamento = em.merge(oldFabIdFabricanteOfMedicamentoListMedicamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFabricante(fabricante.getIdFabricante()) != null) {
                throw new PreexistingEntityException("Fabricante " + fabricante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fabricante fabricante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fabricante persistentFabricante = em.find(Fabricante.class, fabricante.getIdFabricante());
            List<Medicamento> medicamentoListOld = persistentFabricante.getMedicamentoList();
            List<Medicamento> medicamentoListNew = fabricante.getMedicamentoList();
            List<Medicamento> attachedMedicamentoListNew = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListNewMedicamentoToAttach : medicamentoListNew) {
                medicamentoListNewMedicamentoToAttach = em.getReference(medicamentoListNewMedicamentoToAttach.getClass(), medicamentoListNewMedicamentoToAttach.getIdProducto());
                attachedMedicamentoListNew.add(medicamentoListNewMedicamentoToAttach);
            }
            medicamentoListNew = attachedMedicamentoListNew;
            fabricante.setMedicamentoList(medicamentoListNew);
            fabricante = em.merge(fabricante);
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    medicamentoListOldMedicamento.setFabIdFabricante(null);
                    medicamentoListOldMedicamento = em.merge(medicamentoListOldMedicamento);
                }
            }
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    Fabricante oldFabIdFabricanteOfMedicamentoListNewMedicamento = medicamentoListNewMedicamento.getFabIdFabricante();
                    medicamentoListNewMedicamento.setFabIdFabricante(fabricante);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                    if (oldFabIdFabricanteOfMedicamentoListNewMedicamento != null && !oldFabIdFabricanteOfMedicamentoListNewMedicamento.equals(fabricante)) {
                        oldFabIdFabricanteOfMedicamentoListNewMedicamento.getMedicamentoList().remove(medicamentoListNewMedicamento);
                        oldFabIdFabricanteOfMedicamentoListNewMedicamento = em.merge(oldFabIdFabricanteOfMedicamentoListNewMedicamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = fabricante.getIdFabricante();
                if (findFabricante(id) == null) {
                    throw new NonexistentEntityException("The fabricante with id " + id + " no longer exists.");
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
            Fabricante fabricante;
            try {
                fabricante = em.getReference(Fabricante.class, id);
                fabricante.getIdFabricante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fabricante with id " + id + " no longer exists.", enfe);
            }
            List<Medicamento> medicamentoList = fabricante.getMedicamentoList();
            for (Medicamento medicamentoListMedicamento : medicamentoList) {
                medicamentoListMedicamento.setFabIdFabricante(null);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            em.remove(fabricante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fabricante> findFabricanteEntities() {
        return findFabricanteEntities(true, -1, -1);
    }

    public List<Fabricante> findFabricanteEntities(int maxResults, int firstResult) {
        return findFabricanteEntities(false, maxResults, firstResult);
    }

    private List<Fabricante> findFabricanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fabricante.class));
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

    public Fabricante findFabricante(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fabricante.class, id);
        } finally {
            em.close();
        }
    }

    public int getFabricanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fabricante> rt = cq.from(Fabricante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
