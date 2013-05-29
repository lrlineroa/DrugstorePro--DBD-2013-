/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VIEW_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewProveedor.findAll", query = "SELECT v FROM ViewProveedor v"),
    @NamedQuery(name = "ViewProveedor.findByIdProveedor", query = "SELECT v FROM ViewProveedor v WHERE v.idProveedor = :idProveedor"),
    @NamedQuery(name = "ViewProveedor.findByNombreProveedor", query = "SELECT v FROM ViewProveedor v WHERE v.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "ViewProveedor.findByTelefonoProveedor", query = "SELECT v FROM ViewProveedor v WHERE v.telefonoProveedor = :telefonoProveedor"),
    @NamedQuery(name = "ViewProveedor.findByDireccionProveedor", query = "SELECT v FROM ViewProveedor v WHERE v.direccionProveedor = :direccionProveedor")})
public class ViewProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private BigDecimal idProveedor;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Basic(optional = false)
    @Column(name = "TELEFONO_PROVEEDOR")
    private String telefonoProveedor;
    @Basic(optional = false)
    @Column(name = "DIRECCION_PROVEEDOR")
    private String direccionProveedor;

    public ViewProveedor() {
    }

    public ViewProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public ViewProveedor(BigDecimal idProveedor, String nombreProveedor, String telefonoProveedor, String direccionProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.direccionProveedor = direccionProveedor;
    }

    public BigDecimal getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewProveedor)) {
            return false;
        }
        ViewProveedor other = (ViewProveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewProveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
