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
@Table(name = "VIEW_CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewCargo.findAll", query = "SELECT v FROM ViewCargo v"),
    @NamedQuery(name = "ViewCargo.findByIdCargo", query = "SELECT v FROM ViewCargo v WHERE v.idCargo = :idCargo"),
    @NamedQuery(name = "ViewCargo.findByTipoCargo", query = "SELECT v FROM ViewCargo v WHERE v.tipoCargo = :tipoCargo")})
public class ViewCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CARGO")
    private BigDecimal idCargo;
    @Basic(optional = false)
    @Column(name = "TIPO_CARGO")
    private String tipoCargo;

    public ViewCargo() {
    }

    public ViewCargo(BigDecimal idCargo) {
        this.idCargo = idCargo;
    }

    public ViewCargo(BigDecimal idCargo, String tipoCargo) {
        this.idCargo = idCargo;
        this.tipoCargo = tipoCargo;
    }

    public BigDecimal getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(BigDecimal idCargo) {
        this.idCargo = idCargo;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
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
        if (!(object instanceof ViewCargo)) {
            return false;
        }
        ViewCargo other = (ViewCargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewCargo[ idCargo=" + idCargo + " ]";
    }
    
}
