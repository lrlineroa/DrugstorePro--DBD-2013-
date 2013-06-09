/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Views;

import Entities.Persona;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edward
 */
@Entity
@Table(name = "dbd_3.lrlineroa.VIEW_INVENTARIORPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewInventariorpt.findAll", query = "SELECT v FROM ViewInventariorpt v"),
    @NamedQuery(name = "ViewInventariorpt.findByIdInventariorpt", query = "SELECT v FROM ViewInventariorpt v WHERE v.idInventariorpt = :idInventariorpt"),
    @NamedQuery(name = "ViewInventariorpt.findByFechaInv", query = "SELECT v FROM ViewInventariorpt v WHERE v.fechaInv = :fechaInv")})
public class ViewInventariorpt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INVENTARIORPT")
    private Integer idInventariorpt;
    @Basic(optional = false)
    @Column(name = "FECHA_INV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInv;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public ViewInventariorpt() {
    }

    public ViewInventariorpt(Integer idInventariorpt) {
        this.idInventariorpt = idInventariorpt;
    }

    public ViewInventariorpt(Integer idInventariorpt, Date fechaInv) {
        this.idInventariorpt = idInventariorpt;
        this.fechaInv = fechaInv;
    }

    public Integer getIdInventariorpt() {
        return idInventariorpt;
    }

    public void setIdInventariorpt(Integer idInventariorpt) {
        this.idInventariorpt = idInventariorpt;
    }

    public Date getFechaInv() {
        return fechaInv;
    }

    public void setFechaInv(Date fechaInv) {
        this.fechaInv = fechaInv;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
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
