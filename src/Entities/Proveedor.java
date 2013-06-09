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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "dbd_3.lrlineroa.PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedor.findByTelefonoProveedor", query = "SELECT p FROM Proveedor p WHERE p.telefonoProveedor = :telefonoProveedor"),
    @NamedQuery(name = "Proveedor.findByDireccionProveedor", query = "SELECT p FROM Proveedor p WHERE p.direccionProveedor = :direccionProveedor")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Basic(optional = false)
    @Column(name = "TELEFONO_PROVEEDOR")
    private String telefonoProveedor;
    @Basic(optional = false)
    @Column(name = "DIRECCION_PROVEEDOR")
    private String direccionProveedor;
    @JoinTable(name = "VIEW_PROVEEDOR_TIPO_PROV", joinColumns = {
        @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TIPO_PROVEEDOR", referencedColumnName = "ID_TIPO_PROVEEDOR")})
    @ManyToMany
    private List<TipoProveedor> tipoProveedorList;
    @JoinTable(name = "PROVEEDOR_TIPO_PROVEEDOR", joinColumns = {
        @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TIPO_PROVEEDOR", referencedColumnName = "ID_TIPO_PROVEEDOR")})
    @ManyToMany
    private List<TipoProveedor> tipoProveedorList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<Medicamento> medicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<ViewMedicamento> viewMedicamentoList;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(Integer idProveedor, String nombreProveedor, String telefonoProveedor, String direccionProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.direccionProveedor = direccionProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    @XmlTransient
    public List<TipoProveedor> getTipoProveedorList() {
        return tipoProveedorList;
    }

    public void setTipoProveedorList(List<TipoProveedor> tipoProveedorList) {
        this.tipoProveedorList = tipoProveedorList;
    }

    @XmlTransient
    public List<TipoProveedor> getTipoProveedorList1() {
        return tipoProveedorList1;
    }

    public void setTipoProveedorList1(List<TipoProveedor> tipoProveedorList1) {
        this.tipoProveedorList1 = tipoProveedorList1;
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
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
