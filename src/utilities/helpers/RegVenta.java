/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.helpers;

import javax.swing.JButton;

/**
 *
 * @author Administrador
 */

//Esta venta guardará un solo registro para el modelo de la tabla Venta
public class RegVenta {
     
     private Long id;
     private String Name;
     private int quantity;
     private float priceUnit;
     private float priceAll;
    
     private VentaTableModel Model;

    public RegVenta(Long id, String Name, int quantity, float priceUnit, float priceAll, JButton details, JButton remove ,VentaTableModel vTbM) {
        this.id = id;
        this.Name = Name;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
        this.priceAll = priceAll;
        this.Model= vTbM;
    }

   
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the priceUnit
     */
    public float getPriceUnit() {
        return priceUnit;
    }

    /**
     * @param priceUnit the priceUnit to set
     */
    public void setPriceUnit(float priceUnit) {
        this.priceUnit = priceUnit;
    }

    /**
     * @return the priceAll
     */
    public float getPriceAll() {
        return priceAll;
    }

    /**
     * @param priceAll the priceAll to set
     */
    public void setPriceAll(float priceAll) {
        this.priceAll = priceAll;
    }

   
     
}
