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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USO_MEDICAMENTO")
    private BigDecimal idUsoMedicamento;
    @Basic(optional = false)
    @Column(name = "TIPO_USO_PRODUCTO")
    private String tipoUsoProducto;
    @OneToMany(mappedBy = "idUsoMedicamento")
    private List<Medicamento> medicamentoList;

    public UsoMedicamento() {
    }

    public UsoMedicamento(BigDecimal idUsoMedicamento) {
        this.idUsoMedicamento = idUsoMedicamento;
    }

    public UsoMedicamento(BigDecimal idUsoMedicamento, String tipoUsoProducto) {
        this.idUsoMedicamento = idUsoMedicamento;
        this.tipoUsoProducto = tipoUsoProducto;
    }

    public BigDecimal getIdUsoMedicamento() {
        return idUsoMedicamento;
    }

    public void setIdUsoMedicamento(BigDecimal idUsoMedicamento) {
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
