/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edward
 */
@Entity
@Table(name = "dbd_3.lrlineroa.FABRICANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByIdFabricante", query = "SELECT f FROM Fabricante f WHERE f.idFabricante = :idFabricante"),
    @NamedQuery(name = "Fabricante.findByNombreFabricante", query = "SELECT f FROM Fabricante f WHERE f.nombreFabricante = :nombreFabricante")})
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FABRICANTE")
    private Integer idFabricante;
    @Column(name = "NOMBRE_FABRICANTE")
    private String nombreFabricante;
    @JoinTable(name = "PRODUCTO_FABRICANTE", joinColumns = {
        @JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID_FABRICANTE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Medicamento> medicamentoList;
    @JoinTable(name = "VIEW_PRODUCTO_FABRICANTE", joinColumns = {
        @JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID_FABRICANTE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Medicamento> medicamentoList1;

    public Fabricante() {
    }

    public Fabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFabricante != null ? idFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.idFabricante == null && other.idFabricante != null) || (this.idFabricante != null && !this.idFabricante.equals(other.idFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Fabricante[ idFabricante=" + idFabricante + " ]";
    }
    
}
