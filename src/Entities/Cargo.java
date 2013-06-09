/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Views.ViewPersona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edward
 */
@Entity
@Table(name = "CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo"),
    @NamedQuery(name = "Cargo.findByTipoCargo", query = "SELECT c FROM Cargo c WHERE c.tipoCargo = :tipoCargo")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CARGO")
    private Integer idCargo;
    @Basic(optional = false)
    @Column(name = "TIPO_CARGO")
    private String tipoCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargo")
    private List<Persona> personaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargo")
    private List<ViewPersona> viewPersonaList;

    public Cargo() {
    }

    public Cargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Cargo(Integer idCargo, String tipoCargo) {
        this.idCargo = idCargo;
        this.tipoCargo = tipoCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<ViewPersona> getViewPersonaList() {
        return viewPersonaList;
    }

    public void setViewPersonaList(List<ViewPersona> viewPersonaList) {
        this.viewPersonaList = viewPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Cargo[ idCargo=" + idCargo + " ]";
    }
    
}
