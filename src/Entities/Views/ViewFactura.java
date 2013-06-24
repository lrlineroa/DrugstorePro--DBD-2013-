/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Views;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "lrlineroa.VIEW_FACTURA")
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
    @Column(name = "ID_PERSONA")
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private float total;
    @Basic(optional = false)
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;

    public ViewFactura() {
    }

    public ViewFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public ViewFactura(Integer idFactura, float total, Date fechaFactura) {
        this.idFactura = idFactura;
        this.total = total;
        this.fechaFactura = fechaFactura;
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

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
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
        return "Entities.Views.ViewFactura[ idFactura=" + idFactura + " ]";
    }

    /**
     * @return the idPersona
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    
}
