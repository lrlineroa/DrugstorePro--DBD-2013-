/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
 * @author Edward
 */
@Entity
@Table(name = "ADVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advice.findAll", query = "SELECT a FROM Advice a"),
    @NamedQuery(name = "Advice.findByIdAdvice", query = "SELECT a FROM Advice a WHERE a.idAdvice = :idAdvice"),
    @NamedQuery(name = "Advice.findByIdProdRelacionado", query = "SELECT a FROM Advice a WHERE a.idProdRelacionado = :idProdRelacionado"),
    @NamedQuery(name = "Advice.findByCantRegistrada", query = "SELECT a FROM Advice a WHERE a.cantRegistrada = :cantRegistrada")})
public class Advice implements Serializable {
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

    public Advice() {
    }

    public Advice(Integer idAdvice) {
        this.idAdvice = idAdvice;
    }

    public Advice(Integer idAdvice, int idProdRelacionado, int cantRegistrada) {
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
        if (!(object instanceof Advice)) {
            return false;
        }
        Advice other = (Advice) object;
        if ((this.idAdvice == null && other.idAdvice != null) || (this.idAdvice != null && !this.idAdvice.equals(other.idAdvice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Advice[ idAdvice=" + idAdvice + " ]";
    }
    
}
