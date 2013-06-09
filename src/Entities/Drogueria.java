/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Views.ViewPedido;
import Entities.Views.ViewPersona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "dbd_3.lrlineroa.DROGUERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drogueria.findAll", query = "SELECT d FROM Drogueria d"),
    @NamedQuery(name = "Drogueria.findByIdDrogueria", query = "SELECT d FROM Drogueria d WHERE d.idDrogueria = :idDrogueria"),
    @NamedQuery(name = "Drogueria.findByNombreDrogueria", query = "SELECT d FROM Drogueria d WHERE d.nombreDrogueria = :nombreDrogueria"),
    @NamedQuery(name = "Drogueria.findByTelefonoDrogueria", query = "SELECT d FROM Drogueria d WHERE d.telefonoDrogueria = :telefonoDrogueria"),
    @NamedQuery(name = "Drogueria.findByDireccionDrogueria", query = "SELECT d FROM Drogueria d WHERE d.direccionDrogueria = :direccionDrogueria")})
public class Drogueria implements Serializable {
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
    @JoinTable(name = "PRODUCTO_DROGUERIA", joinColumns = {
        @JoinColumn(name = "ID_DROGUERIA", referencedColumnName = "ID_DROGUERIA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Medicamento> medicamentoList;
    @JoinTable(name = "VIEW_PRODUCTO_DROGUERIA", joinColumns = {
        @JoinColumn(name = "ID_DROGUERIA", referencedColumnName = "ID_DROGUERIA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Medicamento> medicamentoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDrogueria")
    private List<Persona> personaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDrogueria")
    private List<Pedido> pedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDrogueria")
    private List<ViewPedido> viewPedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDrogueria")
    private List<ViewPersona> viewPersonaList;

    public Drogueria() {
    }

    public Drogueria(Integer idDrogueria) {
        this.idDrogueria = idDrogueria;
    }

    public Drogueria(Integer idDrogueria, String nombreDrogueria, String telefonoDrogueria, String direccionDrogueria) {
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

    @XmlTransient
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    @XmlTransient
    public List<Medicamento> getMedicamentoList1() {
        return medicamentoList1;
    }

    public void setMedicamentoList1(List<Medicamento> medicamentoList1) {
        this.medicamentoList1 = medicamentoList1;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<ViewPedido> getViewPedidoList() {
        return viewPedidoList;
    }

    public void setViewPedidoList(List<ViewPedido> viewPedidoList) {
        this.viewPedidoList = viewPedidoList;
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
        hash += (idDrogueria != null ? idDrogueria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drogueria)) {
            return false;
        }
        Drogueria other = (Drogueria) object;
        if ((this.idDrogueria == null && other.idDrogueria != null) || (this.idDrogueria != null && !this.idDrogueria.equals(other.idDrogueria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Drogueria[ idDrogueria=" + idDrogueria + " ]";
    }
    
}
