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
@Table(name = "VIEW_CONSOLIDADO_SEMANAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewConsolidadoSemanal.findAll", query = "SELECT v FROM ViewConsolidadoSemanal v"),
    @NamedQuery(name = "ViewConsolidadoSemanal.findByIdConsSemanal", query = "SELECT v FROM ViewConsolidadoSemanal v WHERE v.idConsSemanal = :idConsSemanal"),
    @NamedQuery(name = "ViewConsolidadoSemanal.findByA\u00f1o", query = "SELECT v FROM ViewConsolidadoSemanal v WHERE v.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "ViewConsolidadoSemanal.findByMes", query = "SELECT v FROM ViewConsolidadoSemanal v WHERE v.mes = :mes"),
    @NamedQuery(name = "ViewConsolidadoSemanal.findByDiaInicio", query = "SELECT v FROM ViewConsolidadoSemanal v WHERE v.diaInicio = :diaInicio"),
    @NamedQuery(name = "ViewConsolidadoSemanal.findByDiaFin", query = "SELECT v FROM ViewConsolidadoSemanal v WHERE v.diaFin = :diaFin"),
    @NamedQuery(name = "ViewConsolidadoSemanal.findByTotal", query = "SELECT v FROM ViewConsolidadoSemanal v WHERE v.total = :total")})
public class ViewConsolidadoSemanal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONS_SEMANAL")
    private Integer idConsSemanal;
    @Basic(optional = false)
    @Column(name = "A\u00d1O")
    private int año;
    @Basic(optional = false)
    @Column(name = "MES")
    private int mes;
    @Basic(optional = false)
    @Column(name = "DIA_INICIO")
    private int diaInicio;
    @Basic(optional = false)
    @Column(name = "DIA_FIN")
    private int diaFin;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private int total;

    public ViewConsolidadoSemanal() {
    }

    public ViewConsolidadoSemanal(Integer idConsSemanal) {
        this.idConsSemanal = idConsSemanal;
    }

    public ViewConsolidadoSemanal(Integer idConsSemanal, int año, int mes, int diaInicio, int diaFin, int total) {
        this.idConsSemanal = idConsSemanal;
        this.año = año;
        this.mes = mes;
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.total = total;
    }

    public Integer getIdConsSemanal() {
        return idConsSemanal;
    }

    public void setIdConsSemanal(Integer idConsSemanal) {
        this.idConsSemanal = idConsSemanal;
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

    public int getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public int getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(int diaFin) {
        this.diaFin = diaFin;
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
        hash += (idConsSemanal != null ? idConsSemanal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewConsolidadoSemanal)) {
            return false;
        }
        ViewConsolidadoSemanal other = (ViewConsolidadoSemanal) object;
        if ((this.idConsSemanal == null && other.idConsSemanal != null) || (this.idConsSemanal != null && !this.idConsSemanal.equals(other.idConsSemanal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Views.ViewConsolidadoSemanal[ idConsSemanal=" + idConsSemanal + " ]";
    }
    
}
