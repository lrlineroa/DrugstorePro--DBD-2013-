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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "lrlineroa.VIEW_ADVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewAdvice.findAll", query = "SELECT v FROM ViewAdvice v"),
    @NamedQuery(name = "ViewAdvice.findByIdAdvice", query = "SELECT v FROM ViewAdvice v WHERE v.idAdvice = :idAdvice"),
    @NamedQuery(name = "ViewAdvice.findByIdProdRelacionado", query = "SELECT v FROM ViewAdvice v WHERE v.idProdRelacionado = :idProdRelacionado"),
    @NamedQuery(name = "ViewAdvice.findByCantRegistrada", query = "SELECT v FROM ViewAdvice v WHERE v.cantRegistrada = :cantRegistrada")})
public class ViewAdvice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ADVICE")
    private Integer idAdvice;
    @Basic(optional = false)
    @Column(name = "ID_PROD_RELACIONADO")
    private int idProdRelacionado;
    @Lob
    @Column(name = "TIPO_O_NOTA")
    private String tipoONota;
    @Basic(optional = false)
    @Column(name = "CANT_REGISTRADA")
    private int cantRegistrada;

    public ViewAdvice() {
    }

    public ViewAdvice(Integer idAdvice) {
        this.idAdvice = idAdvice;
    }

    public ViewAdvice(Integer idAdvice, int idProdRelacionado, int cantRegistrada) {
        this.idAdvice = idAdvice;
        this.idProdRelacionado = idProdRelacionado;
        this.cantRegistrada = cantRegistrada;
    }

    public Integer getIdAdvice() {
        return idAdvice;
    }

    public void setIdAdvice(Integer idAdvice) {
        this.idAdvice = idAdvice;
    }

    public int getIdProdRelacionado() {
        return idProdRelacionado;
    }

    public void setIdProdRelacionado(int idProdRelacionado) {
        this.idProdRelacionado = idProdRelacionado;
    }

    public String getTipoONota() {
        return tipoONota;
    }

    public void setTipoONota(String tipoONota) {
        this.tipoONota = tipoONota;
    }

    public int getCantRegistrada() {
        return cantRegistrada;
    }

    public void setCantRegistrada(int cantRegistrada) {
        this.cantRegistrada = cantRegistrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdvice != null ? idAdvice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewAdvice)) {
            return false;
        }
        ViewAdvice other = (ViewAdvice) object;
        if ((this.idAdvice == null && other.idAdvice != null) || (this.idAdvice != null && !this.idAdvice.equals(other.idAdvice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Views.ViewAdvice[ idAdvice=" + idAdvice + " ]";
    }
    
}
