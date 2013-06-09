/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Views;

import Entities.Persona;
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
@Table(name = "dbd_3.lrlineroa.VIEW_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewFactura.findAll", query = "SELECT v FROM ViewFactura v"),
    @NamedQuery(name = "ViewFactura.findByIdFactura", query = "SELECT v FROM ViewFactura v WHERE v.idFactura = :idFactura"),
    @NamedQuery(name = "ViewFactura.findByTotal", query = "SELECT v FROM ViewFactura v WHERE v.total = :total")})
public class ViewFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private float total;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public ViewFactura() {
    }

    public ViewFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public ViewFactura(Integer idFactura, float total) {
        this.idFactura = idFactura;
        this.total = total;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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
