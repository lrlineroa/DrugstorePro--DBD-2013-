/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "VIEW_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewPedido.findAll", query = "SELECT v FROM ViewPedido v"),
    @NamedQuery(name = "ViewPedido.findByIdPedido", query = "SELECT v FROM ViewPedido v WHERE v.idPedido = :idPedido"),
    @NamedQuery(name = "ViewPedido.findByFechaPedido", query = "SELECT v FROM ViewPedido v WHERE v.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "ViewPedido.findByHoraPedido", query = "SELECT v FROM ViewPedido v WHERE v.horaPedido = :horaPedido"),
    @NamedQuery(name = "ViewPedido.findByNombreClientePed", query = "SELECT v FROM ViewPedido v WHERE v.nombreClientePed = :nombreClientePed"),
    @NamedQuery(name = "ViewPedido.findByDireccionClienPedido", query = "SELECT v FROM ViewPedido v WHERE v.direccionClienPedido = :direccionClienPedido"),
    @NamedQuery(name = "ViewPedido.findByTelefonoClientePed", query = "SELECT v FROM ViewPedido v WHERE v.telefonoClientePed = :telefonoClientePed"),
    @NamedQuery(name = "ViewPedido.findBySolicitudEnCurso", query = "SELECT v FROM ViewPedido v WHERE v.solicitudEnCurso = :solicitudEnCurso"),
    @NamedQuery(name = "ViewPedido.findBySolicitudFinalizada", query = "SELECT v FROM ViewPedido v WHERE v.solicitudFinalizada = :solicitudFinalizada")})
public class ViewPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PEDIDO")
    private BigDecimal idPedido;
    @Basic(optional = false)
    @Column(name = "FECHA_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Basic(optional = false)
    @Column(name = "HORA_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaPedido;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CLIENTE_PED")
    private String nombreClientePed;
    @Basic(optional = false)
    @Column(name = "DIRECCION_CLIEN_PEDIDO")
    private String direccionClienPedido;
    @Basic(optional = false)
    @Column(name = "TELEFONO_CLIENTE_PED")
    private String telefonoClientePed;
    @Basic(optional = false)
    @Column(name = "SOLICITUD_EN_CURSO")
    private BigInteger solicitudEnCurso;
    @Basic(optional = false)
    @Column(name = "SOLICITUD_FINALIZADA")
    private BigInteger solicitudFinalizada;

    public ViewPedido() {
    }

    public ViewPedido(BigDecimal idPedido) {
        this.idPedido = idPedido;
    }

    public ViewPedido(BigDecimal idPedido, Date fechaPedido, Date horaPedido, String nombreClientePed, String direccionClienPedido, String telefonoClientePed, BigInteger solicitudEnCurso, BigInteger solicitudFinalizada) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.nombreClientePed = nombreClientePed;
        this.direccionClienPedido = direccionClienPedido;
        this.telefonoClientePed = telefonoClientePed;
        this.solicitudEnCurso = solicitudEnCurso;
        this.solicitudFinalizada = solicitudFinalizada;
    }

    public BigDecimal getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(BigDecimal idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getNombreClientePed() {
        return nombreClientePed;
    }

    public void setNombreClientePed(String nombreClientePed) {
        this.nombreClientePed = nombreClientePed;
    }

    public String getDireccionClienPedido() {
        return direccionClienPedido;
    }

    public void setDireccionClienPedido(String direccionClienPedido) {
        this.direccionClienPedido = direccionClienPedido;
    }

    public String getTelefonoClientePed() {
        return telefonoClientePed;
    }

    public void setTelefonoClientePed(String telefonoClientePed) {
        this.telefonoClientePed = telefonoClientePed;
    }

    public BigInteger getSolicitudEnCurso() {
        return solicitudEnCurso;
    }

    public void setSolicitudEnCurso(BigInteger solicitudEnCurso) {
        this.solicitudEnCurso = solicitudEnCurso;
    }

    public BigInteger getSolicitudFinalizada() {
        return solicitudFinalizada;
    }

    public void setSolicitudFinalizada(BigInteger solicitudFinalizada) {
        this.solicitudFinalizada = solicitudFinalizada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewPedido)) {
            return false;
        }
        ViewPedido other = (ViewPedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewPedido[ idPedido=" + idPedido + " ]";
    }
    
}
