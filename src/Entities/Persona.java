/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombrePersona", query = "SELECT p FROM Persona p WHERE p.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "Persona.findByApellidoPersona", query = "SELECT p FROM Persona p WHERE p.apellidoPersona = :apellidoPersona"),
    @NamedQuery(name = "Persona.findByTelefonoPersona", query = "SELECT p FROM Persona p WHERE p.telefonoPersona = :telefonoPersona"),
    @NamedQuery(name = "Persona.findByDireccionPersona", query = "SELECT p FROM Persona p WHERE p.direccionPersona = :direccionPersona")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSONA")
    private BigDecimal idPersona;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PERSONA")
    private String nombrePersona;
    @Basic(optional = false)
    @Column(name = "APELLIDO_PERSONA")
    private String apellidoPersona;
    @Basic(optional = false)
    @Column(name = "TELEFONO_PERSONA")
    private BigInteger telefonoPersona;
    @Basic(optional = false)
    @Column(name = "DIRECCION_PERSONA")
    private String direccionPersona;
    @Basic(optional = false)
    @Lob
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ID_DROGUERIA", referencedColumnName = "ID_DROGUERIA")
    @ManyToOne(optional = false)
    private Drogueria idDrogueria;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private Cargo idCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Invetariorpt> invetariorptList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Factura> facturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Logs> logsList;

    public Persona() {
    }

    public Persona(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(BigDecimal idPersona, String nombrePersona, String apellidoPersona, BigInteger telefonoPersona, String direccionPersona, String password) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.telefonoPersona = telefonoPersona;
        this.direccionPersona = direccionPersona;
        this.password = password;
    }

    public BigDecimal getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigDecimal idPersona) {
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

    public BigInteger getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(BigInteger telefonoPersona) {
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

    @XmlTransient
    public List<Invetariorpt> getInvetariorptList() {
        return invetariorptList;
    }

    public void setInvetariorptList(List<Invetariorpt> invetariorptList) {
        this.invetariorptList = invetariorptList;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Logs> getLogsList() {
        return logsList;
    }

    public void setLogsList(List<Logs> logsList) {
        this.logsList = logsList;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
