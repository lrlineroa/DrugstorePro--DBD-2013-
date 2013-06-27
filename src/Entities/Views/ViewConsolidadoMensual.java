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
@Table(name = "VIEW_CONSOLIDADO_MENSUAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewConsolidadoMensual.findAll", query = "SELECT v FROM ViewConsolidadoMensual v"),
    @NamedQuery(name = "ViewConsolidadoMensual.findByIdConsMensual", query = "SELECT v FROM ViewConsolidadoMensual v WHERE v.idConsMensual = :idConsMensual"),
    @NamedQuery(name = "ViewConsolidadoMensual.findByAño", query = "SELECT v FROM ViewConsolidadoMensual v WHERE v.año = :año"),
    @NamedQuery(name = "ViewConsolidadoMensual.findByMes", query = "SELECT v FROM ViewConsolidadoMensual v WHERE v.mes = :mes"),
    @NamedQuery(name = "ViewConsolidadoMensual.findByTotal", query = "SELECT v FROM ViewConsolidadoMensual v WHERE v.total = :total")})
public class ViewConsolidadoMensual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONS_MENSUAL")
    private Integer idConsMensual;
    @Basic(optional = false)
    @Column(name = "AÑO")
    private int año;
    @Basic(optional = false)
    @Column(name = "MES")
    private int mes;
    @Basic(optional = false)
    @Column(name = "Total")
    private int total;

    public ViewConsolidadoMensual() {
    }

    public ViewConsolidadoMensual(Integer idConsMensual) {
        this.idConsMensual = idConsMensual;
    }

    public ViewConsolidadoMensual(Integer idConsMensual, int año, int mes, int total) {
        this.idConsMensual = idConsMensual;
        this.año = año;
        this.mes = mes;
        this.total = total;
    }

    public Integer getIdConsMensual() {
        return idConsMensual;
    }

    public void setIdConsMensual(Integer idConsMensual) {
        this.idConsMensual = idConsMensual;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
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
        hash += (idConsMensual != null ? idConsMensual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewConsolidadoMensual)) {
            return false;
        }
        ViewConsolidadoMensual other = (ViewConsolidadoMensual) object;
        if ((this.idConsMensual == null && other.idConsMensual != null) || (this.idConsMensual != null && !this.idConsMensual.equals(other.idConsMensual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Views.ViewConsolidadoMensual[ idConsMensual=" + idConsMensual + " ]";
    }
    
}
