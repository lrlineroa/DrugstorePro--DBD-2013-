/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edward
 */
@Entity
@Table(name = "INVENTARIO_RPT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioRpt.findAll", query = "SELECT i FROM InventarioRpt i"),
    @NamedQuery(name = "InventarioRpt.findByIdInventariorpt", query = "SELECT i FROM InventarioRpt i WHERE i.idInventariorpt = :idInventariorpt"),
    @NamedQuery(name = "InventarioRpt.findByFechaInv", query = "SELECT i FROM InventarioRpt i WHERE i.fechaInv = :fechaInv")})
public class InventarioRpt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_INVENTARIORPT")
    private Integer idInventariorpt;
    @Basic(optional = false)
    @Column(name = "FECHA_INV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInv;
    @JoinTable(name = "PRODUCTO_INVENTARIO", joinColumns = {
        @JoinColumn(name = "ID_INVENTARIORPT", referencedColumnName = "ID_INVENTARIORPT")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Medicamento> medicamentoList;
    @JoinTable(name = "VIEW_PRODUCTO_INVENTARIO", joinColumns = {
        @JoinColumn(name = "ID_INVENTARIORPT", referencedColumnName = "ID_INVENTARIORPT")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Medicamento> medicamentoList1;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public InventarioRpt() {
    }

    public InventarioRpt(Integer idInventariorpt) {
        this.idInventariorpt = idInventariorpt;
    }

    public InventarioRpt(Integer idInventariorpt, Date fechaInv) {
        this.idInventariorpt = idInventariorpt;
        this.fechaInv = fechaInv;
    }

    public Integer getIdInventariorpt() {
        return idInventariorpt;
    }

    public void setIdInventariorpt(Integer idInventariorpt) {
        this.idInventariorpt = idInventariorpt;
    }

    public Date getFechaInv() {
        return fechaInv;
    }

    public void setFechaInv(Date fechaInv) {
        this.fechaInv = fechaInv;
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

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventariorpt != null ? idInventariorpt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioRpt)) {
            return false;
        }
        InventarioRpt other = (InventarioRpt) object;
        if ((this.idInventariorpt == null && other.idInventariorpt != null) || (this.idInventariorpt != null && !this.idInventariorpt.equals(other.idInventariorpt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.InventarioRpt[ idInventariorpt=" + idInventariorpt + " ]";
    }
    
}
