/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.helpers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class VentaTableModel extends AbstractTableModel implements Serializable {
    private List<RegVenta> products=new ArrayList<RegVenta>();
    private String[] labels={"Id","Nombre","Cantidad","Precio unitario","precio","detalles","borrar"};
    int i=0;
    
    public void add(RegVenta rv){
        getProducts().add(rv);
    }
    
    public void delete(int row){
        getProducts().remove(row);
    }
    
    @Override
    public int getRowCount() {
       return getProducts().size();
    }
    

    @Override
    public String getColumnName(int column) {
        return labels[column];
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegVenta r= getProducts().get(rowIndex);
        switch (columnIndex){
            case 0:
            return r.getId();
            case 1:
            return r.getName();
            case 2:
            return r.getQuantity();
            case 3:
            return r.getPriceUnit();
            case 4:
            return r.getPriceAll();
          }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex==5 || columnIndex==6){
        return true;    
        }
        return false;
    }

    /**
     * @return the products
     */
    public List<RegVenta> getProducts() {
        return products;
    }
    
    
     
}
