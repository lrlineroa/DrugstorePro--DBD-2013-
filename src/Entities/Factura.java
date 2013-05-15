/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private BigDecimal idFactura;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private double total;
    @JoinTable(name = "PRODUCTO_FACTURA", joinColumns = {
        @JoinColumn(name = "ID_FACTURA", referencedColumnName = "ID_FACTURA")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private List<Medicamento> medicamentoList;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Factura() {
    }

    public Factura(BigDecimal idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(BigDecimal idFactura, double total) {
        this.idFactura = idFactura;
        this.total = total;
    }

    public BigDecimal getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(BigDecimal idFactura) {
        this.idFactura = idFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @XmlTransient
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
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
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
