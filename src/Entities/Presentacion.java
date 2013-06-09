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
@Table(name = "PRESENTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentacion.findAll", query = "SELECT p FROM Presentacion p"),
    @NamedQuery(name = "Presentacion.findByIdPresentacion", query = "SELECT p FROM Presentacion p WHERE p.idPresentacion = :idPresentacion"),
    @NamedQuery(name = "Presentacion.findByTipoPresentacion", query = "SELECT p FROM Presentacion p WHERE p.tipoPresentacion = :tipoPresentacion")})
public class Presentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRESENTACION")
    private Integer idPresentacion;
    @Basic(optional = false)
    @Column(name = "TIPO_PRESENTACION")
    private String tipoPresentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresentacion")
    private List<Medicamento> medicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresentacion")
    private List<ViewMedicamento> viewMedicamentoList;

    public Presentacion() {
    }

    public Presentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Presentacion(Integer idPresentacion, String tipoPresentacion) {
        this.idPresentacion = idPresentacion;
        this.tipoPresentacion = tipoPresentacion;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getTipoPresentacion() {
        return tipoPresentacion;
    }

    public void setTipoPresentacion(String tipoPresentacion) {
        this.tipoPresentacion = tipoPresentacion;
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
        hash += (idPresentacion != null ? idPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentacion)) {
            return false;
        }
        Presentacion other = (Presentacion) object;
        if ((this.idPresentacion == null && other.idPresentacion != null) || (this.idPresentacion != null && !this.idPresentacion.equals(other.idPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Presentacion[ idPresentacion=" + idPresentacion + " ]";
    }
    
}
