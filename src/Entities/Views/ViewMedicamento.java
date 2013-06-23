/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Views;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
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
    @Basic(optional = false)
    @Column(name = "ID_PRESENTACION")
    private Integer idPresentacion;
    @Basic(optional = false)
    @Column(name = "ID_USO_MEDICAMENTO")
    private Integer idUsoMedicamento;
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PRODUCTO")
    private Float precioProducto;
    @Column(name = "CANTIDAD_PRODUCTO")
    private Integer cantidadProducto;
    @Column(name = "POSOLOGIA_PRODUCTO")
    private String posologiaProducto;
    @Basic(optional=false)
    @Column(name = "ID_TIPO_PRODUCTO")
    private Integer IdTipoProducto;
    @Basic(optional=false)
    @Column(name = "ID_PROVEEDOR")
    private Integer IdProveedor;
    @Basic(optional = false)
    @Column(name = "VENTA_LIBRE")
    private short ventaLibre;

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
        return "Entities.Views.ViewMedicamento[ idProducto=" + idProducto + " ]";
    }

    /**
     * @return the IdTipoProducto
     */
    public Integer getIdTipoProducto() {
        return IdTipoProducto;
    }

    /**
     * @param IdTipoProducto the IdTipoProducto to set
     */
    public void setIdTipoProducto(Integer IdTipoProducto) {
        this.IdTipoProducto = IdTipoProducto;
    }

    /**
     * @return the IdProveedor
     */
    public Integer getIdProveedor() {
        return IdProveedor;
    }

    /**
     * @param IdProveedor the IdProveedor to set
     */
    public void setIdProveedor(Integer IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    /**
     * @return the idPresentacion
     */
    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    /**
     * @param idPresentacion the idPresentacion to set
     */
    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    /**
     * @return the idUsoMedicamento
     */
    public Integer getIdUsoMedicamento() {
        return idUsoMedicamento;
    }

    /**
     * @param idUsoMedicamento the idUsoMedicamento to set
     */
    public void setIdUsoMedicamento(Integer idUsoMedicamento) {
        this.idUsoMedicamento = idUsoMedicamento;
    }
    
}
