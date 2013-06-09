/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edward
 */
@Entity
@Table(name = "MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m"),
    @NamedQuery(name = "Medicamento.findByIdProducto", query = "SELECT m FROM Medicamento m WHERE m.idProducto = :idProducto"),
    @NamedQuery(name = "Medicamento.findByNombreProducto", query = "SELECT m FROM Medicamento m WHERE m.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Medicamento.findByPrecioProducto", query = "SELECT m FROM Medicamento m WHERE m.precioProducto = :precioProducto"),
    @NamedQuery(name = "Medicamento.findByCantidadProducto", query = "SELECT m FROM Medicamento m WHERE m.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "Medicamento.findByPosologiaProducto", query = "SELECT m FROM Medicamento m WHERE m.posologiaProducto = :posologiaProducto"),
    @NamedQuery(name = "Medicamento.findByVentaLibre", query = "SELECT m FROM Medicamento m WHERE m.ventaLibre = :ventaLibre")})
public class Medicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PRODUCTO")
    private Float precioProducto;
    @Column(name = "CANTIDAD_PRODUCTO")
    private Integer cantidadProducto;
    @Column(name = "POSOLOGIA_PRODUCTO")
    private String posologiaProducto;
    @Basic(optional = false)
    @Column(name = "VENTA_LIBRE")
    private short ventaLibre;
    @ManyToMany(mappedBy = "medicamentoList")
    private List<Factura> facturaList;
    @ManyToMany(mappedBy = "medicamentoList")
    private List<Drogueria> drogueriaList;
    @ManyToMany(mappedBy = "medicamentoList")
    private List<Fabricante> fabricanteList;
    @ManyToMany(mappedBy = "medicamentoList1")
    private List<Drogueria> drogueriaList1;
    @ManyToMany(mappedBy = "medicamentoList")
    private List<InventarioRpt> inventarioRptList;
    @ManyToMany(mappedBy = "medicamentoList1")
    private List<InventarioRpt> inventarioRptList1;
    @JoinTable(name = "PEDIDO_PRODUCTO", joinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")})
    @ManyToMany
    private List<Pedido> pedidoList;
    @JoinTable(name = "VIEW_PEDIDO_PRODUCTO", joinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")})
    @ManyToMany
    private List<Pedido> pedidoList1;
    @ManyToMany(mappedBy = "medicamentoList1")
    private List<Fabricante> fabricanteList1;
    @ManyToMany(mappedBy = "medicamentoList1")
    private List<Factura> facturaList1;
    @JoinColumn(name = "ID_USO_MEDICAMENTO", referencedColumnName = "ID_USO_MEDICAMENTO")
    @ManyToOne
    private UsoMedicamento idUsoMedicamento;
    @JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO")
    @ManyToOne(optional = false)
    private TipoProducto idTipoProducto;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @JoinColumn(name = "ID_PRESENTACION", referencedColumnName = "ID_PRESENTACION")
    @ManyToOne(optional = false)
    private Presentacion idPresentacion;

    public Medicamento() {
    }

    public Medicamento(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Medicamento(Integer idProducto, short ventaLibre) {
        this.idProducto = idProducto;
        this.ventaLibre = ventaLibre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getPosologiaProducto() {
        return posologiaProducto;
    }

    public void setPosologiaProducto(String posologiaProducto) {
        this.posologiaProducto = posologiaProducto;
    }

    public short getVentaLibre() {
        return ventaLibre;
    }

    public void setVentaLibre(short ventaLibre) {
        this.ventaLibre = ventaLibre;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Drogueria> getDrogueriaList() {
        return drogueriaList;
    }

    public void setDrogueriaList(List<Drogueria> drogueriaList) {
        this.drogueriaList = drogueriaList;
    }

    @XmlTransient
    public List<Fabricante> getFabricanteList() {
        return fabricanteList;
    }

    public void setFabricanteList(List<Fabricante> fabricanteList) {
        this.fabricanteList = fabricanteList;
    }

    @XmlTransient
    public List<Drogueria> getDrogueriaList1() {
        return drogueriaList1;
    }

    public void setDrogueriaList1(List<Drogueria> drogueriaList1) {
        this.drogueriaList1 = drogueriaList1;
    }

    @XmlTransient
    public List<InventarioRpt> getInventarioRptList() {
        return inventarioRptList;
    }

    public void setInventarioRptList(List<InventarioRpt> inventarioRptList) {
        this.inventarioRptList = inventarioRptList;
    }

    @XmlTransient
    public List<InventarioRpt> getInventarioRptList1() {
        return inventarioRptList1;
    }

    public void setInventarioRptList1(List<InventarioRpt> inventarioRptList1) {
        this.inventarioRptList1 = inventarioRptList1;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList1() {
        return pedidoList1;
    }

    public void setPedidoList1(List<Pedido> pedidoList1) {
        this.pedidoList1 = pedidoList1;
    }

    @XmlTransient
    public List<Fabricante> getFabricanteList1() {
        return fabricanteList1;
    }

    public void setFabricanteList1(List<Fabricante> fabricanteList1) {
        this.fabricanteList1 = fabricanteList1;
    }

    @XmlTransient
    public List<Factura> getFacturaList1() {
        return facturaList1;
    }

    public void setFacturaList1(List<Factura> facturaList1) {
        this.facturaList1 = facturaList1;
    }

    public UsoMedicamento getIdUsoMedicamento() {
        return idUsoMedicamento;
    }

    public void setIdUsoMedicamento(UsoMedicamento idUsoMedicamento) {
        this.idUsoMedicamento = idUsoMedicamento;
    }

    public TipoProducto getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(TipoProducto idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Presentacion getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Presentacion idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Medicamento[ idProducto=" + idProducto + " ]";
    }
    
}
