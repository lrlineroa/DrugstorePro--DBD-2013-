/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "VIEW_INVENTARIORPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewInventariorpt.findAll", query = "SELECT v FROM ViewInventariorpt v"),
    @NamedQuery(name = "ViewInventariorpt.findByIdInventariorpt", query = "SELECT v FROM ViewInventariorpt v WHERE v.idInventariorpt = :idInventariorpt"),
    @NamedQuery(name = "ViewInventariorpt.findByFechaInv", query = "SELECT v FROM ViewInventariorpt v WHERE v.fechaInv = :fechaInv")})
public class ViewInventariorpt implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INVENTARIORPT")
    private BigDecimal idInventariorpt;
    @Basic(optional = false)
    @Column(name = "FECHA_INV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInv;

    public ViewInventariorpt() {
    }

    public ViewInventariorpt(BigDecimal idInventariorpt) {
        this.idInventariorpt = idInventariorpt;
    }

    public ViewInventariorpt(BigDecimal idInventariorpt, Date fechaInv) {
        this.idInventariorpt = idInventariorpt;
        this.fechaInv = fechaInv;
    }

    public BigDecimal getIdInventariorpt() {
        return idInventariorpt;
    }

    public void setIdInventariorpt(BigDecimal idInventariorpt) {
        this.idInventariorpt = idInventariorpt;
    }

    public Date getFechaInv() {
        return fechaInv;
    }

    public void setFechaInv(Date fechaInv) {
        this.fechaInv = fechaInv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventariorpt != null ? idInventariorpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewInventariorpt)) {
            return false;
        }
        ViewInventariorpt other = (ViewInventariorpt) object;
        if ((this.idInventariorpt == null && other.idInventariorpt != null) || (this.idInventariorpt != null && !this.idInventariorpt.equals(other.idInventariorpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewInventariorpt[ idInventariorpt=" + idInventariorpt + " ]";
    }
    
}
