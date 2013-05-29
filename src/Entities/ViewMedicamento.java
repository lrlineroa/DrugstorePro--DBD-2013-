/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "VIEW_MEDICAMENTO")
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private BigDecimal idProducto;
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Column(name = "PRECIO_PRODUCTO")
    private Double precioProducto;
    @Column(name = "CANTIDAD_PRODUCTO")
    private BigInteger cantidadProducto;
    @Column(name = "POSOLOGIA_PRODUCTO")
    private String posologiaProducto;
    @Basic(optional = false)
    @Column(name = "VENTA_LIBRE")
    private BigInteger ventaLibre;

    public ViewMedicamento() {
    }

    public ViewMedicamento(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public ViewMedicamento(BigDecimal idProducto, BigInteger ventaLibre) {
        this.idProducto = idProducto;
        this.ventaLibre = ventaLibre;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public BigInteger getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigInteger cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getPosologiaProducto() {
        return posologiaProducto;
    }

    public void setPosologiaProducto(String posologiaProducto) {
        this.posologiaProducto = posologiaProducto;
    }

    public BigInteger getVentaLibre() {
        return ventaLibre;
    }

    public void setVentaLibre(BigInteger ventaLibre) {
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
        return "Entities.ViewMedicamento[ idProducto=" + idProducto + " ]";
    }
    
}
