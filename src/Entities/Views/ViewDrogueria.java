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
 * @author User
 */
@Entity
@Table(name = "lrlineroa.VIEW_DROGUERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewDrogueria.findAll", query = "SELECT v FROM ViewDrogueria v"),
    @NamedQuery(name = "ViewDrogueria.findByIdDrogueria", query = "SELECT v FROM ViewDrogueria v WHERE v.idDrogueria = :idDrogueria"),
    @NamedQuery(name = "ViewDrogueria.findByNombreDrogueria", query = "SELECT v FROM ViewDrogueria v WHERE v.nombreDrogueria = :nombreDrogueria"),
    @NamedQuery(name = "ViewDrogueria.findByTelefonoDrogueria", query = "SELECT v FROM ViewDrogueria v WHERE v.telefonoDrogueria = :telefonoDrogueria"),
    @NamedQuery(name = "ViewDrogueria.findByDireccionDrogueria", query = "SELECT v FROM ViewDrogueria v WHERE v.direccionDrogueria = :direccionDrogueria")})
public class ViewDrogueria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DROGUERIA")
    private Integer idDrogueria;
    @Basic(optional = false)
    @Column(name = "NOMBRE_DROGUERIA")
    private String nombreDrogueria;
    @Basic(optional = false)
    @Column(name = "TELEFONO_DROGUERIA")
    private String telefonoDrogueria;
    @Basic(optional = false)
    @Column(name = "DIRECCION_DROGUERIA")
    private String direccionDrogueria;

    public ViewDrogueria() {
    }

    public ViewDrogueria(Integer idDrogueria) {
        this.idDrogueria = idDrogueria;
    }

    public ViewDrogueria(Integer idDrogueria, String nombreDrogueria, String telefonoDrogueria, String direccionDrogueria) {
        this.idDrogueria = idDrogueria;
        this.nombreDrogueria = nombreDrogueria;
        this.telefonoDrogueria = telefonoDrogueria;
        this.direccionDrogueria = direccionDrogueria;
    }

    public Integer getIdDrogueria() {
        return idDrogueria;
    }

    public void setIdDrogueria(Integer idDrogueria) {
        this.idDrogueria = idDrogueria;
    }

    public String getNombreDrogueria() {
        return nombreDrogueria;
    }

    public void setNombreDrogueria(String nombreDrogueria) {
        this.nombreDrogueria = nombreDrogueria;
    }

    public String getTelefonoDrogueria() {
        return telefonoDrogueria;
    }

    public void setTelefonoDrogueria(String telefonoDrogueria) {
        this.telefonoDrogueria = telefonoDrogueria;
    }

    public String getDireccionDrogueria() {
        return direccionDrogueria;
    }

    public void setDireccionDrogueria(String direccionDrogueria) {
        this.direccionDrogueria = direccionDrogueria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDrogueria != null ? idDrogueria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewDrogueria)) {
            return false;
        }
        ViewDrogueria other = (ViewDrogueria) object;
        if ((this.idDrogueria == null && other.idDrogueria != null) || (this.idDrogueria != null && !this.idDrogueria.equals(other.idDrogueria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Views.ViewDrogueria[ idDrogueria=" + idDrogueria + " ]";
    }
    
}
