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
import javax.persistence.Id;
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
@Table(name = "dbd_3.lrlineroa.VIEW_BITACORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewBitacora.findAll", query = "SELECT v FROM ViewBitacora v"),
    @NamedQuery(name = "ViewBitacora.findByIdBitacora", query = "SELECT v FROM ViewBitacora v WHERE v.idBitacora = :idBitacora"),
    @NamedQuery(name = "ViewBitacora.findByFecha", query = "SELECT v FROM ViewBitacora v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "ViewBitacora.findByTipoAccion", query = "SELECT v FROM ViewBitacora v WHERE v.tipoAccion = :tipoAccion"),
    @NamedQuery(name = "ViewBitacora.findByTabla", query = "SELECT v FROM ViewBitacora v WHERE v.tabla = :tabla"),
    @NamedQuery(name = "ViewBitacora.findByUsuario", query = "SELECT v FROM ViewBitacora v WHERE v.usuario = :usuario")})
public class ViewBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BITACORA")
    private Integer idBitacora;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "TIPO_ACCION")
    private String tipoAccion;
    @Column(name = "TABLA")
    private String tabla;
    @Column(name = "USUARIO")
    private String usuario;

    public ViewBitacora() {
    }

    public ViewBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public ViewBitacora(Integer idBitacora, Date fecha, String tipoAccion) {
        this.idBitacora = idBitacora;
        this.fecha = fecha;
        this.tipoAccion = tipoAccion;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
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

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewBitacora)) {
            return false;
        }
        ViewBitacora other = (ViewBitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewBitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}
