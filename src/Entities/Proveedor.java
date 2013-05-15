/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author User
 */
@Entity
@Table(name = "PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedor.findByTelefonoProveedor", query = "SELECT p FROM Proveedor p WHERE p.telefonoProveedor = :telefonoProveedor"),
    @NamedQuery(name = "Proveedor.findByDireccionProveedor", query = "SELECT p FROM Proveedor p WHERE p.direccionProveedor = :direccionProveedor")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private BigDecimal idProveedor;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Basic(optional = false)
    @Column(name = "TELEFONO_PROVEEDOR")
    private String telefonoProveedor;
    @Basic(optional = false)
    @Column(name = "DIRECCION_PROVEEDOR")
    private String direccionProveedor;
    @JoinTable(name = "PROVEEDOR_TIPO_PROVEEDOR", joinColumns = {
        @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TIPO_PROVEEDOR", referencedColumnName = "ID_TIPO_PROVEEDOR")})
    @ManyToMany
    private List<TipoProveedor> tipoProveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<Medicamento> medicamentoList;

    public Proveedor() {
    }

    public Proveedor(BigDecimal idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(BigDecimal idProveedor, String nombreProveedor, String telefonoProveedor, String direccionProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.direccionProveedor = direccionProveedor;
    }

    public BigDecimal getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(BigDecimal idProveedor) {
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
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
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
