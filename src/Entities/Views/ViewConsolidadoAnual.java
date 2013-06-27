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
@Table(name = "VIEW_CONSOLIDADO_ANUAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewConsolidadoAnual.findAll", query = "SELECT v FROM ViewConsolidadoAnual v"),
    @NamedQuery(name = "ViewConsolidadoAnual.findByIdConsAnual", query = "SELECT v FROM ViewConsolidadoAnual v WHERE v.idConsAnual = :idConsAnual"),
    @NamedQuery(name = "ViewConsolidadoAnual.findByAño", query = "SELECT v FROM ViewConsolidadoAnual v WHERE v.año = :año"),
    @NamedQuery(name = "ViewConsolidadoAnual.findByTotal", query = "SELECT v FROM ViewConsolidadoAnual v WHERE v.total = :total")})
public class ViewConsolidadoAnual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONS_ANUAL")
    private Integer idConsAnual;
    @Basic(optional = false)
    @Column(name = "AÑO")
    private int año;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private int total;

    public ViewConsolidadoAnual() {
    }

    public ViewConsolidadoAnual(Integer idConsAnual) {
        this.idConsAnual = idConsAnual;
    }

    public ViewConsolidadoAnual(Integer idConsAnual, int año, int total) {
        this.idConsAnual = idConsAnual;
        this.año = año;
        this.total = total;
    }

    public Integer getIdConsAnual() {
        return idConsAnual;
    }

    public void setIdConsAnual(Integer idConsAnual) {
        this.idConsAnual = idConsAnual;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsAnual != null ? idConsAnual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewConsolidadoAnual)) {
            return false;
        }
        ViewConsolidadoAnual other = (ViewConsolidadoAnual) object;
        if ((this.idConsAnual == null && other.idConsAnual != null) || (this.idConsAnual != null && !this.idConsAnual.equals(other.idConsAnual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Views.ViewConsolidadoAnual[ idConsAnual=" + idConsAnual + " ]";
    }
    
}
