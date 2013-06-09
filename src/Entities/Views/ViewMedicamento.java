/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Views;

import Entities.Presentacion;
import Entities.Proveedor;
import Entities.TipoProducto;
import Entities.UsoMedicamento;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edward
 */
@Entity
@Table(name = "dbd_3.lrlineroa.VIEW_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewMedicamento.findAll", query = "SELECT v FROM ViewMedicamento v"),
    @NamedQuery(name = "ViewMedicamento.findByIdProducto", query = "SELECT v FROM ViewMedicamento v WHERE v.idProducto = :idProducto"),
    @NamedQuery(name = "ViewMedicamento.findByNombreProducto", query = "SELECT v FROM ViewMedicamento v WHERE v.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "ViewMedicamento.findByPrecioProducto", query = "SELECT v FROM ViewMedicamento v WHERE v.precioProducto = :precioProducto"),
    @NamedQuery(name = "ViewMedicamento.findByCantidadProducto", query = "SELECT v FROM ViewMedicamento v WHERE v.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "ViewMedicamento.findByPosologiaProducto", query = "SELECT v FROM ViewMedicamento v WHERE v.posologiaProducto = :posologiaProducto"),
    @NamedQuery(name = "ViewMedicamento.findByVentaLibre", query = "SELECT v FROM ViewMedicamento v WHERE v.ventaLibre = :ventaLibre")})
public class ViewMedicamento implements Serializable {
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

    public ViewMedicamento() {
    }

    public ViewMedicamento(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public ViewMedicamento(Integer idProducto, short ventaLibre) {
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
        if (!(object instanceof ViewMedicamento)) {
            return false;
        }
        ViewMedicamento other = (ViewMedicamento) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewMedicamento[ idProducto=" + idProducto + " ]";
    }
    
}
