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
@Table(name = "VIEW_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewFactura.findAll", query = "SELECT v FROM ViewFactura v"),
    @NamedQuery(name = "ViewFactura.findByIdFactura", query = "SELECT v FROM ViewFactura v WHERE v.idFactura = :idFactura"),
    @NamedQuery(name = "ViewFactura.findByTotal", query = "SELECT v FROM ViewFactura v WHERE v.total = :total")})
public class ViewFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private BigDecimal idFactura;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private double total;

    public ViewFactura() {
    }

    public ViewFactura(BigDecimal idFactura) {
        this.idFactura = idFactura;
    }

    public ViewFactura(BigDecimal idFactura, double total) {
        this.idFactura = idFactura;
        this.total = total;
    }

    public BigDecimal getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(BigDecimal idFactura) {
        this.idFactura = idFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewFactura)) {
            return false;
        }
        ViewFactura other = (ViewFactura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewFactura[ idFactura=" + idFactura + " ]";
    }
    
}
