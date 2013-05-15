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
 * @author User
 */
@Entity
@Table(name = "LOGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l"),
    @NamedQuery(name = "Logs.findByIdLog", query = "SELECT l FROM Logs l WHERE l.idLog = :idLog"),
    @NamedQuery(name = "Logs.findByFecha", query = "SELECT l FROM Logs l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Logs.findByTipoAccion", query = "SELECT l FROM Logs l WHERE l.tipoAccion = :tipoAccion"),
    @NamedQuery(name = "Logs.findByDescripcion", query = "SELECT l FROM Logs l WHERE l.descripcion = :descripcion")})
public class Logs implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LOG")
    private BigDecimal idLog;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "TIPO_ACCION")
    private String tipoAccion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Logs() {
    }

    public Logs(BigDecimal idLog) {
        this.idLog = idLog;
    }

    public Logs(BigDecimal idLog, Date fecha, String tipoAccion) {
        this.idLog = idLog;
        this.fecha = fecha;
        this.tipoAccion = tipoAccion;
    }

    public BigDecimal getIdLog() {
        return idLog;
    }

    public void setIdLog(BigDecimal idLog) {
        this.idLog = idLog;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Logs[ idLog=" + idLog + " ]";
    }
    
}
