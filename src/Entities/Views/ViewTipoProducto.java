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
@Table(name = "dbd_3.lrlineroa.VIEW_TIPO_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewTipoProducto.findAll", query = "SELECT v FROM ViewTipoProducto v"),
    @NamedQuery(name = "ViewTipoProducto.findByIdTipoProducto", query = "SELECT v FROM ViewTipoProducto v WHERE v.idTipoProducto = :idTipoProducto"),
    @NamedQuery(name = "ViewTipoProducto.findByTipo", query = "SELECT v FROM ViewTipoProducto v WHERE v.tipo = :tipo")})
public class ViewTipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PRODUCTO")
    private Integer idTipoProducto;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;

    public ViewTipoProducto() {
    }

    public ViewTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public ViewTipoProducto(Integer idTipoProducto, String tipo) {
        this.idTipoProducto = idTipoProducto;
        this.tipo = tipo;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProducto != null ? idTipoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewTipoProducto)) {
            return false;
        }
        ViewTipoProducto other = (ViewTipoProducto) object;
        if ((this.idTipoProducto == null && other.idTipoProducto != null) || (this.idTipoProducto != null && !this.idTipoProducto.equals(other.idTipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Views.ViewTipoProducto[ idTipoProducto=" + idTipoProducto + " ]";
    }
    
}
