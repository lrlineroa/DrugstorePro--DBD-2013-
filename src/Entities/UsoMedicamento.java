/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Entities.Views.ViewMedicamento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "USO_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsoMedicamento.findAll", query = "SELECT u FROM UsoMedicamento u"),
    @NamedQuery(name = "UsoMedicamento.findByIdUsoMedicamento", query = "SELECT u FROM UsoMedicamento u WHERE u.idUsoMedicamento = :idUsoMedicamento"),
    @NamedQuery(name = "UsoMedicamento.findByTipoUsoProducto", query = "SELECT u FROM UsoMedicamento u WHERE u.tipoUsoProducto = :tipoUsoProducto")})
public class UsoMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USO_MEDICAMENTO")
    private Integer idUsoMedicamento;
    @Basic(optional = false)
    @Column(name = "TIPO_USO_PRODUCTO")
    private String tipoUsoProducto;
    @OneToMany(mappedBy = "idUsoMedicamento")
    private List<Medicamento> medicamentoList;
    @OneToMany(mappedBy = "idUsoMedicamento")
    private List<ViewMedicamento> viewMedicamentoList;

    public UsoMedicamento() {
    }

    public UsoMedicamento(Integer idUsoMedicamento) {
        this.idUsoMedicamento = idUsoMedicamento;
    }

    public UsoMedicamento(Integer idUsoMedicamento, String tipoUsoProducto) {
        this.idUsoMedicamento = idUsoMedicamento;
        this.tipoUsoProducto = tipoUsoProducto;
    }

    public Integer getIdUsoMedicamento() {
        return idUsoMedicamento;
    }

    public void setIdUsoMedicamento(Integer idUsoMedicamento) {
        this.idUsoMedicamento = idUsoMedicamento;
    }

    public String getTipoUsoProducto() {
        return tipoUsoProducto;
    }

    public void setTipoUsoProducto(String tipoUsoProducto) {
        this.tipoUsoProducto = tipoUsoProducto;
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
        hash += (idUsoMedicamento != null ? idUsoMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsoMedicamento)) {
            return false;
        }
        UsoMedicamento other = (UsoMedicamento) object;
        if ((this.idUsoMedicamento == null && other.idUsoMedicamento != null) || (this.idUsoMedicamento != null && !this.idUsoMedicamento.equals(other.idUsoMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UsoMedicamento[ idUsoMedicamento=" + idUsoMedicamento + " ]";
    }
    
}
