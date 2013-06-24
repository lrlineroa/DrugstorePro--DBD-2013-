/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.helpers;

/**
 *
 * @author MAURO
 */
//Clase reg inventary para manejar el inventario mediante busqueda de facturas

public class RegReport {
    private Long id;
     private String Name;
     private int quantity;
     
    
     private ReportTableModel Model;

    public RegReport(Long id, String Name, int quantity, ReportTableModel Model) {
        this.id = id;
        this.Name = Name;
        this.quantity = quantity;
        
        this.Model = Model;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return the Model
     */
    public ReportTableModel getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(ReportTableModel Model) {
        this.Model = Model;
    }
     
     
}
