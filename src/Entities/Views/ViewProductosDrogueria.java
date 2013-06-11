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
 * @author Edward
 */
@Entity
@Table(name = "VIEW_PRODUCTOS_DROGUERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViewProductosDrogueria.findAll", query = "SELECT v FROM ViewProductosDrogueria v"),
    @NamedQuery(name = "ViewProductosDrogueria.findByIdProducto", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.idProducto = :idProducto"),
    @NamedQuery(name = "ViewProductosDrogueria.findByNombreProducto", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "ViewProductosDrogueria.findByPrecioProducto", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.precioProducto = :precioProducto"),
    @NamedQuery(name = "ViewProductosDrogueria.findByCantidadProducto", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "ViewProductosDrogueria.findByPosologiaProducto", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.posologiaProducto = :posologiaProducto"),
    @NamedQuery(name = "ViewProductosDrogueria.findByVentaLibre", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.ventaLibre = :ventaLibre"),
    @NamedQuery(name = "ViewProductosDrogueria.findByIdDrogueria", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.idDrogueria = :idDrogueria"),
    @NamedQuery(name = "ViewProductosDrogueria.findByNombreDrogueria", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.nombreDrogueria = :nombreDrogueria"),
    @NamedQuery(name = "ViewProductosDrogueria.findByTelefonoDrogueria", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.telefonoDrogueria = :telefonoDrogueria"),
    @NamedQuery(name = "ViewProductosDrogueria.findByDireccionDrogueria", query = "SELECT v FROM ViewProductosDrogueria v WHERE v.direccionDrogueria = :direccionDrogueria")})
public class ViewProductosDrogueria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_PRODUCTO")
    private Float precioProducto;
    @Column(name = "CANTIDAD_PRODUCTO")
    private Integer cantidadProducto;
    @Column(name = "POSOLOGIA_PRODUCTO")
    private String posologiaProducto;
    @Basic(optional = false)
    @Column(name = "VENTA_LIBRE")
    private short ventaLibre;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DROGUERIA")
    private int idDrogueria;
    @Basic(optional = false)
    @Column(name = "NOMBRE_DROGUERIA")
    private String nombreDrogueria;
    @Basic(optional = false)
    @Column(name = "TELEFONO_DROGUERIA")
    private String telefonoDrogueria;
    @Basic(optional = false)
    @Column(name = "DIRECCION_DROGUERIA")
    private String direccionDrogueria;

    public ViewProductosDrogueria() {
    }

    public ViewProductosDrogueria(int idDrogueria) {
        this.idDrogueria = idDrogueria;
    }

    public ViewProductosDrogueria(int idDrogueria, short ventaLibre, String nombreDrogueria, String telefonoDrogueria, String direccionDrogueria) {
        this.idDrogueria = idDrogueria;
        this.ventaLibre = ventaLibre;
        this.nombreDrogueria = nombreDrogueria;
        this.telefonoDrogueria = telefonoDrogueria;
        this.direccionDrogueria = direccionDrogueria;
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

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getPosologiaProducto() {
        return posologiaProducto;
    }

    public void setPosologiaProducto(String posologiaProducto) {
        this.posologiaProducto = posologiaProducto;
    }

    public short getVentaLibre() {
        return ventaLibre;
    }

    public void setVentaLibre(short ventaLibre) {
        this.ventaLibre = ventaLibre;
    }

    public int getIdDrogueria() {
        return idDrogueria;
    }

    public void setIdDrogueria(int idDrogueria) {
        this.idDrogueria = idDrogueria;
    }

    public String getNombreDrogueria() {
        return nombreDrogueria;
    }

    public void setNombreDrogueria(String nombreDrogueria) {
        this.nombreDrogueria = nombreDrogueria;
    }

    public String getTelefonoDrogueria() {
        return telefonoDrogueria;
    }

    public void setTelefonoDrogueria(String telefonoDrogueria) {
        this.telefonoDrogueria = telefonoDrogueria;
    }

    public String getDireccionDrogueria() {
        return direccionDrogueria;
    }

    public void setDireccionDrogueria(String direccionDrogueria) {
        this.direccionDrogueria = direccionDrogueria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDrogueria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViewProductosDrogueria)) {
            return false;
        }
        ViewProductosDrogueria other = (ViewProductosDrogueria) object;
        if (this.idDrogueria != other.idDrogueria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ViewProductosDrogueria[ idDrogueria=" + idDrogueria + " ]";
    }
    
}
