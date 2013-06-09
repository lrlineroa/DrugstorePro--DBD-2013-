/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Views;

import Entities.Cargo;
import Entities.Drogueria;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "dbd_3.lrlineroa.VIEW_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewPersona.findAll", query = "SELECT v FROM ViewPersona v"),
    @NamedQuery(name = "ViewPersona.findByIdPersona", query = "SELECT v FROM ViewPersona v WHERE v.idPersona = :idPersona"),
    @NamedQuery(name = "ViewPersona.findByNombrePersona", query = "SELECT v FROM ViewPersona v WHERE v.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "ViewPersona.findByApellidoPersona", query = "SELECT v FROM ViewPersona v WHERE v.apellidoPersona = :apellidoPersona"),
    @NamedQuery(name = "ViewPersona.findByTelefonoPersona", query = "SELECT v FROM ViewPersona v WHERE v.telefonoPersona = :telefonoPersona"),
    @NamedQuery(name = "ViewPersona.findByDireccionPersona", query = "SELECT v FROM ViewPersona v WHERE v.direccionPersona = :direccionPersona"),
    @NamedQuery(name = "ViewPersona.findByNombreDeUsuario", query = "SELECT v FROM ViewPersona v WHERE v.nombreDeUsuario = :nombreDeUsuario")})
public class ViewPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PERSONA")
    private String nombrePersona;
    @Basic(optional = false)
    @Column(name = "APELLIDO_PERSONA")
    private String apellidoPersona;
    @Basic(optional = false)
    @Column(name = "TELEFONO_PERSONA")
    private int telefonoPersona;
    @Basic(optional = false)
    @Column(name = "DIRECCION_PERSONA")
    private String direccionPersona;
    @Basic(optional = false)
    @Lob
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "NOMBRE_DE_USUARIO")
    private String nombreDeUsuario;
    @JoinColumn(name = "ID_DROGUERIA", referencedColumnName = "ID_DROGUERIA")
    @ManyToOne(optional = false)
    private Drogueria idDrogueria;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private Cargo idCargo;

    public ViewPersona() {
    }

    public ViewPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public ViewPersona(Integer idPersona, String nombrePersona, String apellidoPersona, int telefonoPersona, String direccionPersona, String password, String nombreDeUsuario) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.telefonoPersona = telefonoPersona;
        this.direccionPersona = direccionPersona;
        this.password = password;
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public int getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(int telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public Drogueria getIdDrogueria() {
        return idDrogueria;
    }

    public void setIdDrogueria(Drogueria idDrogueria) {
        this.idDrogueria = idDrogueria;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewPersona)) {
            return false;
        }
        ViewPersona other = (ViewPersona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewPersona[ idPersona=" + idPersona + " ]";
    }
    
}
