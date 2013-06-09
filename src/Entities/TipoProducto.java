/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Views.ViewMedicamento;
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
@Table(name = "dbd_3.lrlineroa.TIPO_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t"),
    @NamedQuery(name = "TipoProducto.findByIdTipoProducto", query = "SELECT t FROM TipoProducto t WHERE t.idTipoProducto = :idTipoProducto"),
    @NamedQuery(name = "TipoProducto.findByTipo", query = "SELECT t FROM TipoProducto t WHERE t.tipo = :tipo")})
public class TipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PRODUCTO")
    private Integer idTipoProducto;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProducto")
    private List<Medicamento> medicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoProducto")
    private List<ViewMedicamento> viewMedicamentoList;

    public TipoProducto() {
    }

    public TipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public TipoProducto(Integer idTipoProducto, String tipo) {
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

    @XmlTransient
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    @XmlTransient
    public List<ViewMedicamento> getViewMedicamentoList() {
        return viewMedicamentoList;
    }

    public void setViewMedicamentoList(List<ViewMedicamento> viewMedicamentoList) {
        this.viewMedicamentoList = viewMedicamentoList;
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
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.idTipoProducto == null && other.idTipoProducto != null) || (this.idTipoProducto != null && !this.idTipoProducto.equals(other.idTipoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TipoProducto[ idTipoProducto=" + idTipoProducto + " ]";
    }
    
}
