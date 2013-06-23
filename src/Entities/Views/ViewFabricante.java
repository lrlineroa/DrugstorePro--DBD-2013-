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
@Table(name = "dbd_3.lrlineroa.VIEW_FABRICANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewFabricante.findAll", query = "SELECT v FROM ViewFabricante v"),
    @NamedQuery(name = "ViewFabricante.findByIdFabricante", query = "SELECT v FROM ViewFabricante v WHERE v.idFabricante = :idFabricante"),
    @NamedQuery(name = "ViewFabricante.findByNombreFabricante", query = "SELECT v FROM ViewFabricante v WHERE v.nombreFabricante = :nombreFabricante")})
public class ViewFabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_FABRICANTE")
    private Integer idFabricante;
    @Column(name = "NOMBRE_FABRICANTE")
    private String nombreFabricante;

    public ViewFabricante() {
    }

    public ViewFabricante(Integer idFabricante) {
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
        return "Entities.Views.ViewFabricante[ idFabricante=" + idFabricante + " ]";
    }
    
}
