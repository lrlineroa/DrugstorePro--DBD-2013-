/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.helpers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RIVERA
 */
public class InventaryTableModel extends AbstractTableModel {
    private List<RegInventary> products= new ArrayList<RegInventary>();
    private String[] labels={"IdProducto", "Nombre de Producto","Cantidad","borrar"};
    
    int i=0;
    
    public void add(RegInventary ri){
        getProducts().add(ri);
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
       return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RegInventary r= getProducts().get(rowIndex);
        switch (columnIndex){
            case 0:
            return r.getId();
            case 1:
            return r.getName();
            case 2:
            return r.getQuantity();
            }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex==3){
        return true;    
        }
        return false;
    }

    /**
     * @return the products
     */
    public List<RegInventary> getProducts() {
        return products;
    }
    
}
