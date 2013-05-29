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
@Table(name = "VIEW_USO_MEDIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewUsoMedic.findAll", query = "SELECT v FROM ViewUsoMedic v"),
    @NamedQuery(name = "ViewUsoMedic.findByIdUsoMedicamento", query = "SELECT v FROM ViewUsoMedic v WHERE v.idUsoMedicamento = :idUsoMedicamento"),
    @NamedQuery(name = "ViewUsoMedic.findByTipoUsoProducto", query = "SELECT v FROM ViewUsoMedic v WHERE v.tipoUsoProducto = :tipoUsoProducto")})
public class ViewUsoMedic implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USO_MEDICAMENTO")
    private BigDecimal idUsoMedicamento;
    @Basic(optional = false)
    @Column(name = "TIPO_USO_PRODUCTO")
    private String tipoUsoProducto;

    public ViewUsoMedic() {
    }

    public ViewUsoMedic(BigDecimal idUsoMedicamento) {
        this.idUsoMedicamento = idUsoMedicamento;
    }

    public ViewUsoMedic(BigDecimal idUsoMedicamento, String tipoUsoProducto) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsoMedicamento != null ? idUsoMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewUsoMedic)) {
            return false;
        }
        ViewUsoMedic other = (ViewUsoMedic) object;
        if ((this.idUsoMedicamento == null && other.idUsoMedicamento != null) || (this.idUsoMedicamento != null && !this.idUsoMedicamento.equals(other.idUsoMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewUsoMedic[ idUsoMedicamento=" + idUsoMedicamento + " ]";
    }
    
}
