/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.helpers;

//import Entities.ProductoGeneral;
//import boundary_package.InvGui;
//import boundary_package.SellGui;
//import control_package.BussinesControl;
import Boundary_Package.SellGui;
import Control_Package.BussinesControl;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import Entities.Views.ViewMedicamento;

/**
 *
 * @author Administrador
 */
public class MyEditor extends AbstractCellEditor implements TableCellEditor,ActionListener {

    private JTable table; 
    protected VentaTableModel tableModel;
    private InventaryTableModel tableModelInv;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private SellGui sellgui;
    private JTable tableinv;
    private BussinesControl buscontrol=new BussinesControl();
    private ViewMedicamento producto;
    public MyEditor(JTable sel, SellGui sellgui) {
        button =new JButton();
        button2=new JButton();
        button.addActionListener(this);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel= (VentaTableModel) table.getModel();
                producto=buscontrol.searchProductById(new Long(tableModel.getProducts().get(table.getEditingRow()).getId()));
                JOptionPane.showMessageDialog(null,producto.toString(), "info", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("/Icons/giantplaylist.png")));
            }
        });
        table=sel;
        this.sellgui=sellgui;
        
        
    }

    public MyEditor(JTable TableInv) {
        button3=new JButton();
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tableModelInv=(InventaryTableModel) tableinv.getModel();
                tableModelInv.delete(tableinv.getEditingRow());
                tableinv.updateUI();
            }
        });
        tableinv= TableInv;
        
    }

   

    
    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (column ==3){
            button3.setIcon(new ImageIcon(getClass().getResource("/Icons/cross.png")));    
            return button3;
        }
        if (column == 5){
            
            button2.setIcon(new ImageIcon(getClass().getResource("/Icons/playlist.png")));     
            return button2;
        }
        if (column == 6){
              
//            this.actualRow=row;
            button.setIcon(new ImageIcon(getClass().getResource("/Icons/cross.png")));    
            return button;
        }
            return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        tableModel=(VentaTableModel) table.getModel();
        sellgui.SumTotal(Float.parseFloat(tableModel.getValueAt(table.getEditingRow(), 4).toString()),false);
        tableModel.delete(table.getEditingRow());
        table.updateUI();
        
        
        
    }

    
    
}
