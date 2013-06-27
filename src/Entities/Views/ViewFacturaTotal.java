/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Views;

import java.io.Serializable;
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
 * @author Edward
 */
@Entity
@Table(name = "lrlineroa.VIEW_FACTURA_TOTAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewFacturaTotal.findAll", query = "SELECT v FROM ViewFacturaTotal v"),
    @NamedQuery(name = "ViewFacturaTotal.findByIdFactura", query = "SELECT v FROM ViewFacturaTotal v WHERE v.idFactura = :idFactura"),
    @NamedQuery(name = "ViewFacturaTotal.findByFechaFactura", query = "SELECT v FROM ViewFacturaTotal v WHERE v.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "ViewFacturaTotal.findByIdProducto", query = "SELECT v FROM ViewFacturaTotal v WHERE v.idProducto = :idProducto"),
    @NamedQuery(name = "ViewFacturaTotal.findByNombreProducto", query = "SELECT v FROM ViewFacturaTotal v WHERE v.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "ViewFacturaTotal.findByPrecioProducto", query = "SELECT v FROM ViewFacturaTotal v WHERE v.precioProducto = :precioProducto"),
    @NamedQuery(name = "ViewFacturaTotal.findByCantidadVendida", query = "SELECT v FROM ViewFacturaTotal v WHERE v.cantidadVendida = :cantidadVendida"),
    @NamedQuery(name = "ViewFacturaTotal.findByTotalProducto", query = "SELECT v FROM ViewFacturaTotal v WHERE v.totalProducto = :totalProducto"),
    @NamedQuery(name = "ViewFacturaTotal.findByTotalFactura", query = "SELECT v FROM ViewFacturaTotal v WHERE v.totalFactura = :totalFactura")})
public class ViewFacturaTotal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID_FACTURA")
    private int idFactura;
    @Basic(optional = false)
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    @Id
    private int idProducto;
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PRODUCTO")
    private Float precioProducto;
    @Column(name = "CANTIDAD_VENDIDA")
    private Integer cantidadVendida;
    @Column(name = "TOTAL_PRODUCTO")
    private Float totalProducto;
    @Basic(optional = false)
    @Column(name = "TOTAL_FACTURA")
    private float totalFactura;
    @Column(name = "IVA")
    private Integer iva;

    public ViewFacturaTotal() {
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public Float getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(Float totalProducto) {
        this.totalProducto = totalProducto;
    }

    public float getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(float totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }
    
}
