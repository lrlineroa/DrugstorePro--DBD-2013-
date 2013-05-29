package utilities.helpers;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author Administrador
 */
public class MyRender implements TableCellRenderer {
    ImageIcon imgcross=new ImageIcon(getClass().getResource("/Icons/cross.png"));
    ImageIcon imgDetails=new ImageIcon(getClass().getResource("/Icons/playlist.png"));
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column==3)
            
        return new JButton(imgcross);   
        if (column==5)
        return new JButton(imgDetails);
        if (column==6)
        return new JButton(imgcross);   
        return null;
    }
    
}
