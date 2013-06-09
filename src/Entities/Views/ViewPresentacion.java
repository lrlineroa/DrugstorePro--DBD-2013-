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
 * @author Edward
 */
@Entity
@Table(name = "dbd_3.lrlineroa.VIEW_PRESENTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewPresentacion.findAll", query = "SELECT v FROM ViewPresentacion v"),
    @NamedQuery(name = "ViewPresentacion.findByIdPresentacion", query = "SELECT v FROM ViewPresentacion v WHERE v.idPresentacion = :idPresentacion"),
    @NamedQuery(name = "ViewPresentacion.findByTipoPresentacion", query = "SELECT v FROM ViewPresentacion v WHERE v.tipoPresentacion = :tipoPresentacion")})
public class ViewPresentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRESENTACION")
    private Integer idPresentacion;
    @Basic(optional = false)
    @Column(name = "TIPO_PRESENTACION")
    private String tipoPresentacion;

    public ViewPresentacion() {
    }

    public ViewPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public ViewPresentacion(Integer idPresentacion, String tipoPresentacion) {
        this.idPresentacion = idPresentacion;
        this.tipoPresentacion = tipoPresentacion;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getTipoPresentacion() {
        return tipoPresentacion;
    }

    public void setTipoPresentacion(String tipoPresentacion) {
        this.tipoPresentacion = tipoPresentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresentacion != null ? idPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewPresentacion)) {
            return false;
        }
        ViewPresentacion other = (ViewPresentacion) object;
        if ((this.idPresentacion == null && other.idPresentacion != null) || (this.idPresentacion != null && !this.idPresentacion.equals(other.idPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewPresentacion[ idPresentacion=" + idPresentacion + " ]";
    }
    
}
