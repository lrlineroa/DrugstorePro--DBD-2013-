/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "TIPO_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProveedor.findAll", query = "SELECT t FROM TipoProveedor t"),
    @NamedQuery(name = "TipoProveedor.findByIdTipoProveedor", query = "SELECT t FROM TipoProveedor t WHERE t.idTipoProveedor = :idTipoProveedor"),
    @NamedQuery(name = "TipoProveedor.findByTipoProveedor", query = "SELECT t FROM TipoProveedor t WHERE t.tipoProveedor = :tipoProveedor")})
public class TipoProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PROVEEDOR")
    private BigDecimal idTipoProveedor;
    @Basic(optional = false)
    @Column(name = "TIPO_PROVEEDOR")
    private String tipoProveedor;
    @ManyToMany(mappedBy = "tipoProveedorList")
    private List<Proveedor> proveedorList;

    public TipoProveedor() {
    }

    public TipoProveedor(BigDecimal idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

    public TipoProveedor(BigDecimal idTipoProveedor, String tipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
        this.tipoProveedor = tipoProveedor;
    }

    public BigDecimal getIdTipoProveedor() {
        return idTipoProveedor;
    }

    public void setIdTipoProveedor(BigDecimal idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProveedor != null ? idTipoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProveedor)) {
            return false;
        }
        TipoProveedor other = (TipoProveedor) object;
        if ((this.idTipoProveedor == null && other.idTipoProveedor != null) || (this.idTipoProveedor != null && !this.idTipoProveedor.equals(other.idTipoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TipoProveedor[ idTipoProveedor=" + idTipoProveedor + " ]";
    }
    
}
