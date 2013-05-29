/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "VIEW_FABRICANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewFabricante.findAll", query = "SELECT v FROM ViewFabricante v"),
    @NamedQuery(name = "ViewFabricante.findByIdFabricante", query = "SELECT v FROM ViewFabricante v WHERE v.idFabricante = :idFabricante"),
    @NamedQuery(name = "ViewFabricante.findByNombreFabricante", query = "SELECT v FROM ViewFabricante v WHERE v.nombreFabricante = :nombreFabricante")})
public class ViewFabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FABRICANTE")
    private BigDecimal idFabricante;
    @Column(name = "NOMBRE_FABRICANTE")
    private String nombreFabricante;

    public ViewFabricante() {
    }

    public ViewFabricante(BigDecimal idFabricante) {
        this.idFabricante = idFabricante;
    }

    public BigDecimal getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(BigDecimal idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
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
        if (!(object instanceof ViewFabricante)) {
            return false;
        }
        ViewFabricante other = (ViewFabricante) object;
        if ((this.idFabricante == null && other.idFabricante != null) || (this.idFabricante != null && !this.idFabricante.equals(other.idFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewFabricante[ idFabricante=" + idFabricante + " ]";
    }
    
}
