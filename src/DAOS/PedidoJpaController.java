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
import Entities.Medicamento;
import Entities.Pedido;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) throws PreexistingEntityException, Exception {
        if (pedido.getMedicamentoList() == null) {
            pedido.setMedicamentoList(new ArrayList<Medicamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Drogueria idDrogueria = pedido.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria = em.getReference(idDrogueria.getClass(), idDrogueria.getIdDrogueria());
                pedido.setIdDrogueria(idDrogueria);
            }
            List<Medicamento> attachedMedicamentoList = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListMedicamentoToAttach : pedido.getMedicamentoList()) {
                medicamentoListMedicamentoToAttach = em.getReference(medicamentoListMedicamentoToAttach.getClass(), medicamentoListMedicamentoToAttach.getIdProducto());
                attachedMedicamentoList.add(medicamentoListMedicamentoToAttach);
            }
            pedido.setMedicamentoList(attachedMedicamentoList);
            em.persist(pedido);
            if (idDrogueria != null) {
                idDrogueria.getPedidoList().add(pedido);
                idDrogueria = em.merge(idDrogueria);
            }
            for (Medicamento medicamentoListMedicamento : pedido.getMedicamentoList()) {
                medicamentoListMedicamento.getPedidoList().add(pedido);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPedido(pedido.getIdPedido()) != null) {
                throw new PreexistingEntityException("Pedido " + pedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            Drogueria idDrogueriaOld = persistentPedido.getIdDrogueria();
            Drogueria idDrogueriaNew = pedido.getIdDrogueria();
            List<Medicamento> medicamentoListOld = persistentPedido.getMedicamentoList();
            List<Medicamento> medicamentoListNew = pedido.getMedicamentoList();
            if (idDrogueriaNew != null) {
                idDrogueriaNew = em.getReference(idDrogueriaNew.getClass(), idDrogueriaNew.getIdDrogueria());
                pedido.setIdDrogueria(idDrogueriaNew);
            }
            List<Medicamento> attachedMedicamentoListNew = new ArrayList<Medicamento>();
            for (Medicamento medicamentoListNewMedicamentoToAttach : medicamentoListNew) {
                medicamentoListNewMedicamentoToAttach = em.getReference(medicamentoListNewMedicamentoToAttach.getClass(), medicamentoListNewMedicamentoToAttach.getIdProducto());
                attachedMedicamentoListNew.add(medicamentoListNewMedicamentoToAttach);
            }
            medicamentoListNew = attachedMedicamentoListNew;
            pedido.setMedicamentoList(medicamentoListNew);
            pedido = em.merge(pedido);
            if (idDrogueriaOld != null && !idDrogueriaOld.equals(idDrogueriaNew)) {
                idDrogueriaOld.getPedidoList().remove(pedido);
                idDrogueriaOld = em.merge(idDrogueriaOld);
            }
            if (idDrogueriaNew != null && !idDrogueriaNew.equals(idDrogueriaOld)) {
                idDrogueriaNew.getPedidoList().add(pedido);
                idDrogueriaNew = em.merge(idDrogueriaNew);
            }
            for (Medicamento medicamentoListOldMedicamento : medicamentoListOld) {
                if (!medicamentoListNew.contains(medicamentoListOldMedicamento)) {
                    medicamentoListOldMedicamento.getPedidoList().remove(pedido);
                    medicamentoListOldMedicamento = em.merge(medicamentoListOldMedicamento);
                }
            }
            for (Medicamento medicamentoListNewMedicamento : medicamentoListNew) {
                if (!medicamentoListOld.contains(medicamentoListNewMedicamento)) {
                    medicamentoListNewMedicamento.getPedidoList().add(pedido);
                    medicamentoListNewMedicamento = em.merge(medicamentoListNewMedicamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = pedido.getIdPedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
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
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            Drogueria idDrogueria = pedido.getIdDrogueria();
            if (idDrogueria != null) {
                idDrogueria.getPedidoList().remove(pedido);
                idDrogueria = em.merge(idDrogueria);
            }
            List<Medicamento> medicamentoList = pedido.getMedicamentoList();
            for (Medicamento medicamentoListMedicamento : medicamentoList) {
                medicamentoListMedicamento.getPedidoList().remove(pedido);
                medicamentoListMedicamento = em.merge(medicamentoListMedicamento);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
