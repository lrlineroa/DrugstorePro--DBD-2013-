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
@Table(name = "lrlineroa.VIEW_PRODUCTO_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewProductoFactura.findAll", query = "SELECT v FROM ViewProductoFactura v"),
    @NamedQuery(name = "ViewProductoFactura.findByIdFactura", query = "SELECT v FROM ViewProductoFactura v WHERE v.idFactura = :idFactura"),
    @NamedQuery(name = "ViewProductoFactura.findByIdProducto", query = "SELECT v FROM ViewProductoFactura v WHERE v.idProducto = :idProducto"),
    @NamedQuery(name = "ViewProductoFactura.findByCantidadVendida", query = "SELECT v FROM ViewProductoFactura v WHERE v.cantidadVendida = :cantidadVendida")})
public class ViewProductoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private int idFactura;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;
    @Column(name = "CANTIDAD_VENDIDA")
    private Integer cantidadVendida;

    public ViewProductoFactura() {
    }

    public ViewProductoFactura(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewProductoFactura)) {
            return false;
        }
        ViewProductoFactura other = (ViewProductoFactura) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Views.ViewProductoFactura[ idProducto=" + idProducto + " ]";
    }
    
}
