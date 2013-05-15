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
import Entities.UsoMedicamento;
import Entities.TipoProducto;
import Entities.Proveedor;
import Entities.Presentacion;
import Entities.Fabricante;
import Entities.Factura;
import java.util.ArrayList;
import java.util.List;
import Entities.Drogueria;
import Entities.Invetariorpt;
import Entities.Medicamento;
import Entities.Pedido;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class MedicamentoJpaController implements Serializable {

    public MedicamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Medicamento medicamento) throws PreexistingEntityException, Exception {
        if (medicamento.getFacturaList() == null) {
            medicamento.setFacturaList(new ArrayList<Factura>());
        }
        if (medicamento.getDrogueriaList() == null) {
            medicamento.setDrogueriaList(new ArrayList<Drogueria>());
        }
        if (medicamento.getInvetariorptList() == null) {
            medicamento.setInvetariorptList(new ArrayList<Invetariorpt>());
        }
        if (medicamento.getPedidoList() == null) {
            medicamento.setPedidoList(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsoMedicamento idUsoMedicamento = medicamento.getIdUsoMedicamento();
            if (idUsoMedicamento != null) {
                idUsoMedicamento = em.getReference(idUsoMedicamento.getClass(), idUsoMedicamento.getIdUsoMedicamento());
                medicamento.setIdUsoMedicamento(idUsoMedicamento);
            }
            TipoProducto idTipoProducto = medicamento.getIdTipoProducto();
            if (idTipoProducto != null) {
                idTipoProducto = em.getReference(idTipoProducto.getClass(), idTipoProducto.getIdTipoProducto());
                medicamento.setIdTipoProducto(idTipoProducto);
            }
            Proveedor idProveedor = medicamento.getIdProveedor();
            if (idProveedor != null) {
                idProveedor = em.getReference(idProveedor.getClass(), idProveedor.getIdProveedor());
                medicamento.setIdProveedor(idProveedor);
            }
            Presentacion idPresentacion = medicamento.getIdPresentacion();
            if (idPresentacion != null) {
                idPresentacion = em.getReference(idPresentacion.getClass(), idPresentacion.getIdPresentacion());
                medicamento.setIdPresentacion(idPresentacion);
            }
            Fabricante fabIdFabricante = medicamento.getFabIdFabricante();
            if (fabIdFabricante != null) {
                fabIdFabricante = em.getReference(fabIdFabricante.getClass(), fabIdFabricante.getIdFabricante());
                medicamento.setFabIdFabricante(fabIdFabricante);
            }
            List<Factura> attachedFacturaList = new ArrayList<Factura>();
            for (Factura facturaListFacturaToAttach : medicamento.getFacturaList()) {
                facturaListFacturaToAttach = em.getReference(facturaListFacturaToAttach.getClass(), facturaListFacturaToAttach.getIdFactura());
                attachedFacturaList.add(facturaListFacturaToAttach);
            }
            medicamento.setFacturaList(attachedFacturaList);
            List<Drogueria> attachedDrogueriaList = new ArrayList<Drogueria>();
            for (Drogueria drogueriaListDrogueriaToAttach : medicamento.getDrogueriaList()) {
                drogueriaListDrogueriaToAttach = em.getReference(drogueriaListDrogueriaToAttach.getClass(), drogueriaListDrogueriaToAttach.getIdDrogueria());
                attachedDrogueriaList.add(drogueriaListDrogueriaToAttach);
            }
            medicamento.setDrogueriaList(attachedDrogueriaList);
            List<Invetariorpt> attachedInvetariorptList = new ArrayList<Invetariorpt>();
            for (Invetariorpt invetariorptListInvetariorptToAttach : medicamento.getInvetariorptList()) {
                invetariorptListInvetariorptToAttach = em.getReference(invetariorptListInvetariorptToAttach.getClass(), invetariorptListInvetariorptToAttach.getIdInventariorpt());
                attachedInvetariorptList.add(invetariorptListInvetariorptToAttach);
            }
            medicamento.setInvetariorptList(attachedInvetariorptList);
            List<Pedido> attachedPedidoList = new ArrayList<Pedido>();
            for (Pedido pedidoListPedidoToAttach : medicamento.getPedidoList()) {
                pedidoListPedidoToAttach = em.getReference(pedidoListPedidoToAttach.getClass(), pedidoListPedidoToAttach.getIdPedido());
                attachedPedidoList.add(pedidoListPedidoToAttach);
            }
            medicamento.setPedidoList(attachedPedidoList);
            em.persist(medicamento);
            if (idUsoMedicamento != null) {
                idUsoMedicamento.getMedicamentoList().add(medicamento);
                idUsoMedicamento = em.merge(idUsoMedicamento);
            }
            if (idTipoProducto != null) {
                idTipoProducto.getMedicamentoList().add(medicamento);
                idTipoProducto = em.merge(idTipoProducto);
            }
            if (idProveedor != null) {
                idProveedor.getMedicamentoList().add(medicamento);
                idProveedor = em.merge(idProveedor);
            }
            if (idPresentacion != null) {
                idPresentacion.getMedicamentoList().add(medicamento);
                idPresentacion = em.merge(idPresentacion);
            }
            if (fabIdFabricante != null) {
                fabIdFabricante.getMedicamentoList().add(medicamento);
                fabIdFabricante = em.merge(fabIdFabricante);
            }
            for (Factura facturaListFactura : medicamento.getFacturaList()) {
                facturaListFactura.getMedicamentoList().add(medicamento);
                facturaListFactura = em.merge(facturaListFactura);
            }
            for (Drogueria drogueriaListDrogueria : medicamento.getDrogueriaList()) {
                drogueriaListDrogueria.getMedicamentoList().add(medicamento);
                drogueriaListDrogueria = em.merge(drogueriaListDrogueria);
            }
            for (Invetariorpt invetariorptListInvetariorpt : medicamento.getInvetariorptList()) {
                invetariorptListInvetariorpt.getMedicamentoList().add(medicamento);
                invetariorptListInvetariorpt = em.merge(invetariorptListInvetariorpt);
            }
            for (Pedido pedidoListPedido : medicamento.getPedidoList()) {
                pedidoListPedido.getMedicamentoList().add(medicamento);
                pedidoListPedido = em.merge(pedidoListPedido);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMedicamento(medicamento.getIdProducto()) != null) {
                throw new PreexistingEntityException("Medicamento " + medicamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medicamento medicamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Medicamento persistentMedicamento = em.find(Medicamento.class, medicamento.getIdProducto());
            UsoMedicamento idUsoMedicamentoOld = persistentMedicamento.getIdUsoMedicamento();
            UsoMedicamento idUsoMedicamentoNew = medicamento.getIdUsoMedicamento();
            TipoProducto idTipoProductoOld = persistentMedicamento.getIdTipoProducto();
            TipoProducto idTipoProductoNew = medicamento.getIdTipoProducto();
            Proveedor idProveedorOld = persistentMedicamento.getIdProveedor();
            Proveedor idProveedorNew = medicamento.getIdProveedor();
            Presentacion idPresentacionOld = persistentMedicamento.getIdPresentacion();
            Presentacion idPresentacionNew = medicamento.getIdPresentacion();
            Fabricante fabIdFabricanteOld = persistentMedicamento.getFabIdFabricante();
            Fabricante fabIdFabricanteNew = medicamento.getFabIdFabricante();
            List<Factura> facturaListOld = persistentMedicamento.getFacturaList();
            List<Factura> facturaListNew = medicamento.getFacturaList();
            List<Drogueria> drogueriaListOld = persistentMedicamento.getDrogueriaList();
            List<Drogueria> drogueriaListNew = medicamento.getDrogueriaList();
            List<Invetariorpt> invetariorptListOld = persistentMedicamento.getInvetariorptList();
            List<Invetariorpt> invetariorptListNew = medicamento.getInvetariorptList();
            List<Pedido> pedidoListOld = persistentMedicamento.getPedidoList();
            List<Pedido> pedidoListNew = medicamento.getPedidoList();
            if (idUsoMedicamentoNew != null) {
                idUsoMedicamentoNew = em.getReference(idUsoMedicamentoNew.getClass(), idUsoMedicamentoNew.getIdUsoMedicamento());
                medicamento.setIdUsoMedicamento(idUsoMedicamentoNew);
            }
            if (idTipoProductoNew != null) {
                idTipoProductoNew = em.getReference(idTipoProductoNew.getClass(), idTipoProductoNew.getIdTipoProducto());
                medicamento.setIdTipoProducto(idTipoProductoNew);
            }
            if (idProveedorNew != null) {
                idProveedorNew = em.getReference(idProveedorNew.getClass(), idProveedorNew.getIdProveedor());
                medicamento.setIdProveedor(idProveedorNew);
            }
            if (idPresentacionNew != null) {
                idPresentacionNew = em.getReference(idPresentacionNew.getClass(), idPresentacionNew.getIdPresentacion());
                medicamento.setIdPresentacion(idPresentacionNew);
            }
            if (fabIdFabricanteNew != null) {
                fabIdFabricanteNew = em.getReference(fabIdFabricanteNew.getClass(), fabIdFabricanteNew.getIdFabricante());
                medicamento.setFabIdFabricante(fabIdFabricanteNew);
            }
            List<Factura> attachedFacturaListNew = new ArrayList<Factura>();
            for (Factura facturaListNewFacturaToAttach : facturaListNew) {
                facturaListNewFacturaToAttach = em.getReference(facturaListNewFacturaToAttach.getClass(), facturaListNewFacturaToAttach.getIdFactura());
                attachedFacturaListNew.add(facturaListNewFacturaToAttach);
            }
            facturaListNew = attachedFacturaListNew;
            medicamento.setFacturaList(facturaListNew);
            List<Drogueria> attachedDrogueriaListNew = new ArrayList<Drogueria>();
            for (Drogueria drogueriaListNewDrogueriaToAttach : drogueriaListNew) {
                drogueriaListNewDrogueriaToAttach = em.getReference(drogueriaListNewDrogueriaToAttach.getClass(), drogueriaListNewDrogueriaToAttach.getIdDrogueria());
                attachedDrogueriaListNew.add(drogueriaListNewDrogueriaToAttach);
            }
            drogueriaListNew = attachedDrogueriaListNew;
            medicamento.setDrogueriaList(drogueriaListNew);
            List<Invetariorpt> attachedInvetariorptListNew = new ArrayList<Invetariorpt>();
            for (Invetariorpt invetariorptListNewInvetariorptToAttach : invetariorptListNew) {
                invetariorptListNewInvetariorptToAttach = em.getReference(invetariorptListNewInvetariorptToAttach.getClass(), invetariorptListNewInvetariorptToAttach.getIdInventariorpt());
                attachedInvetariorptListNew.add(invetariorptListNewInvetariorptToAttach);
            }
            invetariorptListNew = attachedInvetariorptListNew;
            medicamento.setInvetariorptList(invetariorptListNew);
            List<Pedido> attachedPedidoListNew = new ArrayList<Pedido>();
            for (Pedido pedidoListNewPedidoToAttach : pedidoListNew) {
                pedidoListNewPedidoToAttach = em.getReference(pedidoListNewPedidoToAttach.getClass(), pedidoListNewPedidoToAttach.getIdPedido());
                attachedPedidoListNew.add(pedidoListNewPedidoToAttach);
            }
            pedidoListNew = attachedPedidoListNew;
            medicamento.setPedidoList(pedidoListNew);
            medicamento = em.merge(medicamento);
            if (idUsoMedicamentoOld != null && !idUsoMedicamentoOld.equals(idUsoMedicamentoNew)) {
                idUsoMedicamentoOld.getMedicamentoList().remove(medicamento);
                idUsoMedicamentoOld = em.merge(idUsoMedicamentoOld);
            }
            if (idUsoMedicamentoNew != null && !idUsoMedicamentoNew.equals(idUsoMedicamentoOld)) {
                idUsoMedicamentoNew.getMedicamentoList().add(medicamento);
                idUsoMedicamentoNew = em.merge(idUsoMedicamentoNew);
            }
            if (idTipoProductoOld != null && !idTipoProductoOld.equals(idTipoProductoNew)) {
                idTipoProductoOld.getMedicamentoList().remove(medicamento);
                idTipoProductoOld = em.merge(idTipoProductoOld);
            }
            if (idTipoProductoNew != null && !idTipoProductoNew.equals(idTipoProductoOld)) {
                idTipoProductoNew.getMedicamentoList().add(medicamento);
                idTipoProductoNew = em.merge(idTipoProductoNew);
            }
            if (idProveedorOld != null && !idProveedorOld.equals(idProveedorNew)) {
                idProveedorOld.getMedicamentoList().remove(medicamento);
                idProveedorOld = em.merge(idProveedorOld);
            }
            if (idProveedorNew != null && !idProveedorNew.equals(idProveedorOld)) {
                idProveedorNew.getMedicamentoList().add(medicamento);
                idProveedorNew = em.merge(idProveedorNew);
            }
            if (idPresentacionOld != null && !idPresentacionOld.equals(idPresentacionNew)) {
                idPresentacionOld.getMedicamentoList().remove(medicamento);
                idPresentacionOld = em.merge(idPresentacionOld);
            }
            if (idPresentacionNew != null && !idPresentacionNew.equals(idPresentacionOld)) {
                idPresentacionNew.getMedicamentoList().add(medicamento);
                idPresentacionNew = em.merge(idPresentacionNew);
            }
            if (fabIdFabricanteOld != null && !fabIdFabricanteOld.equals(fabIdFabricanteNew)) {
                fabIdFabricanteOld.getMedicamentoList().remove(medicamento);
                fabIdFabricanteOld = em.merge(fabIdFabricanteOld);
            }
            if (fabIdFabricanteNew != null && !fabIdFabricanteNew.equals(fabIdFabricanteOld)) {
                fabIdFabricanteNew.getMedicamentoList().add(medicamento);
                fabIdFabricanteNew = em.merge(fabIdFabricanteNew);
            }
            for (Factura facturaListOldFactura : facturaListOld) {
                if (!facturaListNew.contains(facturaListOldFactura)) {
                    facturaListOldFactura.getMedicamentoList().remove(medicamento);
                    facturaListOldFactura = em.merge(facturaListOldFactura);
                }
            }
            for (Factura facturaListNewFactura : facturaListNew) {
                if (!facturaListOld.contains(facturaListNewFactura)) {
                    facturaListNewFactura.getMedicamentoList().add(medicamento);
                    facturaListNewFactura = em.merge(facturaListNewFactura);
                }
            }
            for (Drogueria drogueriaListOldDrogueria : drogueriaListOld) {
                if (!drogueriaListNew.contains(drogueriaListOldDrogueria)) {
                    drogueriaListOldDrogueria.getMedicamentoList().remove(medicamento);
                    drogueriaListOldDrogueria = em.merge(drogueriaListOldDrogueria);
                }
            }
            for (Drogueria drogueriaListNewDrogueria : drogueriaListNew) {
                if (!drogueriaListOld.contains(drogueriaListNewDrogueria)) {
                    drogueriaListNewDrogueria.getMedicamentoList().add(medicamento);
                    drogueriaListNewDrogueria = em.merge(drogueriaListNewDrogueria);
                }
            }
            for (Invetariorpt invetariorptListOldInvetariorpt : invetariorptListOld) {
                if (!invetariorptListNew.contains(invetariorptListOldInvetariorpt)) {
                    invetariorptListOldInvetariorpt.getMedicamentoList().remove(medicamento);
                    invetariorptListOldInvetariorpt = em.merge(invetariorptListOldInvetariorpt);
                }
            }
            for (Invetariorpt invetariorptListNewInvetariorpt : invetariorptListNew) {
                if (!invetariorptListOld.contains(invetariorptListNewInvetariorpt)) {
                    invetariorptListNewInvetariorpt.getMedicamentoList().add(medicamento);
                    invetariorptListNewInvetariorpt = em.merge(invetariorptListNewInvetariorpt);
                }
            }
            for (Pedido pedidoListOldPedido : pedidoListOld) {
                if (!pedidoListNew.contains(pedidoListOldPedido)) {
                    pedidoListOldPedido.getMedicamentoList().remove(medicamento);
                    pedidoListOldPedido = em.merge(pedidoListOldPedido);
                }
            }
            for (Pedido pedidoListNewPedido : pedidoListNew) {
                if (!pedidoListOld.contains(pedidoListNewPedido)) {
                    pedidoListNewPedido.getMedicamentoList().add(medicamento);
                    pedidoListNewPedido = em.merge(pedidoListNewPedido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = medicamento.getIdProducto();
                if (findMedicamento(id) == null) {
                    throw new NonexistentEntityException("The medicamento with id " + id + " no longer exists.");
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
            Medicamento medicamento;
            try {
                medicamento = em.getReference(Medicamento.class, id);
                medicamento.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medicamento with id " + id + " no longer exists.", enfe);
            }
            UsoMedicamento idUsoMedicamento = medicamento.getIdUsoMedicamento();
            if (idUsoMedicamento != null) {
                idUsoMedicamento.getMedicamentoList().remove(medicamento);
                idUsoMedicamento = em.merge(idUsoMedicamento);
            }
            TipoProducto idTipoProducto = medicamento.getIdTipoProducto();
            if (idTipoProducto != null) {
                idTipoProducto.getMedicamentoList().remove(medicamento);
                idTipoProducto = em.merge(idTipoProducto);
            }
            Proveedor idProveedor = medicamento.getIdProveedor();
            if (idProveedor != null) {
                idProveedor.getMedicamentoList().remove(medicamento);
                idProveedor = em.merge(idProveedor);
            }
            Presentacion idPresentacion = medicamento.getIdPresentacion();
            if (idPresentacion != null) {
                idPresentacion.getMedicamentoList().remove(medicamento);
                idPresentacion = em.merge(idPresentacion);
            }
            Fabricante fabIdFabricante = medicamento.getFabIdFabricante();
            if (fabIdFabricante != null) {
                fabIdFabricante.getMedicamentoList().remove(medicamento);
                fabIdFabricante = em.merge(fabIdFabricante);
            }
            List<Factura> facturaList = medicamento.getFacturaList();
            for (Factura facturaListFactura : facturaList) {
                facturaListFactura.getMedicamentoList().remove(medicamento);
                facturaListFactura = em.merge(facturaListFactura);
            }
            List<Drogueria> drogueriaList = medicamento.getDrogueriaList();
            for (Drogueria drogueriaListDrogueria : drogueriaList) {
                drogueriaListDrogueria.getMedicamentoList().remove(medicamento);
                drogueriaListDrogueria = em.merge(drogueriaListDrogueria);
            }
            List<Invetariorpt> invetariorptList = medicamento.getInvetariorptList();
            for (Invetariorpt invetariorptListInvetariorpt : invetariorptList) {
                invetariorptListInvetariorpt.getMedicamentoList().remove(medicamento);
                invetariorptListInvetariorpt = em.merge(invetariorptListInvetariorpt);
            }
            List<Pedido> pedidoList = medicamento.getPedidoList();
            for (Pedido pedidoListPedido : pedidoList) {
                pedidoListPedido.getMedicamentoList().remove(medicamento);
                pedidoListPedido = em.merge(pedidoListPedido);
            }
            em.remove(medicamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medicamento> findMedicamentoEntities() {
        return findMedicamentoEntities(true, -1, -1);
    }

    public List<Medicamento> findMedicamentoEntities(int maxResults, int firstResult) {
        return findMedicamentoEntities(false, maxResults, firstResult);
    }

    private List<Medicamento> findMedicamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Medicamento.class));
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

    public Medicamento findMedicamento(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medicamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Medicamento> rt = cq.from(Medicamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
