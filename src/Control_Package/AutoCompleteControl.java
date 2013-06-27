/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Package;

import Entities.Views.ViewProductosDrogueria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Administrador
 */
public class AutoCompleteControl {

    private BussinesControl pGS = new BussinesControl();
    private List<String> VectorData;

    //This method returns the index of the vector when finds the most minimun coincidence with DatumtoSearch
    public static int getPositionVector(String DatumtoSearch, ArrayList<String> Vector) {
        try {
            for (String u : Vector) {
                if (DatumtoSearch.equals(u.substring(0, DatumtoSearch.length()))) {
                    return Vector.indexOf(u);
                }
            }
        } catch (NullPointerException exc) {
            String message = exc.getMessage();
            System.out.println(message);
        }


        return -1;
    }

    //This method returns the text of the vector when finds the most minimun coincidence with DatumtoSearch
    //if Internal is true the vector will contain the productsnames in this Drugstore, if not the vector will contains the globals products names
    public String getTextOfCoincidence(String DatumtoSearch, List<String> Vector, boolean internal) {
        List<ViewProductosDrogueria> productos;
        if (internal) {
            productos = pGS.searchProductsByDrogueria(LoginControl.usuarioActivo.getIdDrogueria());
        } else {
            productos = pGS.getAllProducts();
        }
        VectorData = new ArrayList<>();
        for (ViewProductosDrogueria p : productos){
            VectorData.add(p.getNombreProducto());
        }
        try {
            for (String u : Vector) {
                if (DatumtoSearch.length() < u.length() + 1) {
                    if (DatumtoSearch.equals(u.substring(0, DatumtoSearch.length()))) {
                        return u;
                    }
                }

            }
        } catch (NullPointerException exc) {
            String message = exc.getMessage();
            System.out.println(message);
        }


        return "";
    }

    public void AddTextToTextField(JTextField jtf, String datumToSearch, boolean internal) throws BadLocationException {
        if (!getTextOfCoincidence(datumToSearch, VectorData, internal).isEmpty()) {
            String newDatum = this.getTextOfCoincidence(datumToSearch, VectorData, internal);
            int ActualNum = jtf.getText().length();
            String DatumSearched = newDatum.substring(ActualNum, newDatum.length());
            if (!(newDatum.isEmpty() || DatumSearched.isEmpty())) {
                jtf.getDocument().insertString(jtf.getCaretPosition(), DatumSearched, null);
                jtf.select(ActualNum, jtf.getText().length());

            }
        }

    }
}
