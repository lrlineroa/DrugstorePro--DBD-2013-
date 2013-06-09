/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edward
 */
@Entity
@Table(name = "dbd_3.lrlineroa.PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByFechaPedido", query = "SELECT p FROM Pedido p WHERE p.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "Pedido.findByHoraPedido", query = "SELECT p FROM Pedido p WHERE p.horaPedido = :horaPedido"),
    @NamedQuery(name = "Pedido.findByNombreClientePed", query = "SELECT p FROM Pedido p WHERE p.nombreClientePed = :nombreClientePed"),
    @NamedQuery(name = "Pedido.findByDireccionClienPedido", query = "SELECT p FROM Pedido p WHERE p.direccionClienPedido = :direccionClienPedido"),
    @NamedQuery(name = "Pedido.findByTelefonoClientePed", query = "SELECT p FROM Pedido p WHERE p.telefonoClientePed = :telefonoClientePed"),
    @NamedQuery(name = "Pedido.findBySolicitudEnCurso", query = "SELECT p FROM Pedido p WHERE p.solicitudEnCurso = :solicitudEnCurso"),
    @NamedQuery(name = "Pedido.findBySolicitudFinalizada", query = "SELECT p FROM Pedido p WHERE p.solicitudFinalizada = :solicitudFinalizada")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PEDIDO")
    private Integer idPedido;
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
    private short solicitudEnCurso;
    @Basic(optional = false)
    @Column(name = "SOLICITUD_FINALIZADA")
    private short solicitudFinalizada;
    @ManyToMany(mappedBy = "pedidoList")
    private List<Medicamento> medicamentoList;
    @ManyToMany(mappedBy = "pedidoList1")
    private List<Medicamento> medicamentoList1;
    @JoinColumn(name = "ID_DROGUERIA", referencedColumnName = "ID_DROGUERIA")
    @ManyToOne(optional = false)
    private Drogueria idDrogueria;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, Date fechaPedido, Date horaPedido, String nombreClientePed, String direccionClienPedido, String telefonoClientePed, short solicitudEnCurso, short solicitudFinalizada) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.nombreClientePed = nombreClientePed;
        this.direccionClienPedido = direccionClienPedido;
        this.telefonoClientePed = telefonoClientePed;
        this.solicitudEnCurso = solicitudEnCurso;
        this.solicitudFinalizada = solicitudFinalizada;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
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

    public short getSolicitudEnCurso() {
        return solicitudEnCurso;
    }

    public void setSolicitudEnCurso(short solicitudEnCurso) {
        this.solicitudEnCurso = solicitudEnCurso;
    }

    public short getSolicitudFinalizada() {
        return solicitudFinalizada;
    }

    public void setSolicitudFinalizada(short solicitudFinalizada) {
        this.solicitudFinalizada = solicitudFinalizada;
    }

    @XmlTransient
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    @XmlTransient
    public List<Medicamento> getMedicamentoList1() {
        return medicamentoList1;
    }

    public void setMedicamentoList1(List<Medicamento> medicamentoList1) {
        this.medicamentoList1 = medicamentoList1;
    }

    public Drogueria getIdDrogueria() {
        return idDrogueria;
    }

    public void setIdDrogueria(Drogueria idDrogueria) {
        this.idDrogueria = idDrogueria;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
