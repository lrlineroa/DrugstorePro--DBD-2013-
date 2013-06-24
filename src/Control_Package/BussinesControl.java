/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Package;

import DAOS.DAOFactory;
import Entities.Views.ViewFactura;
import Entities.Views.ViewMedicamento;
import Entities.Views.ViewPedido;
import Entities.Views.ViewProductoFactura;
import Entities.Views.ViewProductosDrogueria;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lrlineroa this Class contains all the controllers that refers to the principle of the bussines such as sell inventary, and query of
 * products on the pharmacy, or orders.
 */
public class BussinesControl {
    // this method returns a Product with a specific ID given

    public ViewMedicamento searchProductById(Long Id) {
        return DAOFactory.getInstance().getViewMedicamentoDAO().findViewMedicamentoById(Id.intValue());
    }

    // this method returns a Order with a specific ID given
    public ViewPedido searchPedidoById(Integer ID) {
        return DAOFactory.getInstance().getViewPedidoDAO().findViewPedidoById(ID);
    }

    //this method returns a list of productos such name is like the given.
    public List<ViewMedicamento> searchProductsByName(String name) {
        return DAOFactory.getInstance().getViewMedicamentoDAO().findViewMedicamentoListByName(name);
    }

    // this method returns a specific  product with a ID a name given
    public ViewMedicamento searchProductByIdAndName(Integer ID, String name) {
        return DAOFactory.getInstance().getViewMedicamentoDAO().findViewMedicamentoByIdAndName(ID, name);
    }

    //this method make a sell of a specific product
    public int makeSell(Long Id, int amount) throws Exception {
        DAOFactory.getInstance().getViewMedicamentoDAO().Update(Id.intValue(), amount, false);
        return 1;
    }

    //this method make a inventary of a specific product
    public int makeInventary(Long Id, int amount) throws Exception {
        DAOFactory.getInstance().getViewMedicamentoDAO().Update(Id.intValue(), amount, true);
        return 1;
    }

    public ViewMedicamento searchProductByName(String text) {
        List<ViewMedicamento> searchProducts = searchProductsByName(text);
        if (searchProducts != null && !searchProducts.isEmpty()) {
            return searchProducts.get(0);
        } else {
            return null;
        }
    }

    public List<ViewProductosDrogueria> searchProductsByDrogueria(Integer idDrogueria) {
        return DAOFactory.getInstance().getViewProductosDrogueriaDAO().findViewProductosDrogueria(idDrogueria);
    }

    public List<ViewProductosDrogueria> getAllProducts() {
        return DAOFactory.getInstance().getViewProductosDrogueriaDAO().findViewProductosDrogueriaEntities();
    }

    public String verifyProductToSell(Long Id, String name, int Quanty) {
        ViewMedicamento searchProduct = searchProductByIdAndName(Id.intValue(), name);
//        if(Quanty==4)
//        assert can==0: can;
        if (searchProduct == null) {
            return "producto no encontrado";
        }
        int can = searchProduct.getCantidadProducto();
        if (Quanty > can) {
            int excess = Quanty - can;
            return " Ops.. la cantidad supera " + excess + " unidades a la existente";
        }
        if (Quanty == can) {
            return "Quedan 0 productos en el inventario";
        }
        return "0";
    }

    public String verifyProductToSell(Long Id, int Quanty) {
        ViewMedicamento searchProduct = searchProductById(Id);
        if (searchProduct == null) {
            return "producto no encontrado";
        }
        int can = searchProduct.getCantidadProducto();
        if (Quanty > can) {
            int excess = Quanty - can;
            return " Ops.. la cantidad supera " + excess + " unidades a la existente";
        }
        if (Quanty == can) {
            return "Quedan 0 productos en el inventario";
        }
        return "0";
    }

    public void newFactura(Integer idPersona, float total, List<ViewProductoFactura> productos) throws Exception {
        ViewFactura factura = new ViewFactura();
        factura.setIdPersona(idPersona);
        factura.setTotal(total);
        Calendar d = Calendar.getInstance();
        factura.setFechaFactura(d.getTime());
        String s = String.valueOf(d.get(Calendar.DAY_OF_MONTH)) + String.valueOf(d.get(Calendar.MONTH)+1)
                + String.valueOf(d.get(Calendar.HOUR_OF_DAY)) + String.valueOf(d.get(Calendar.MINUTE));
        s = s.concat(String.valueOf(idPersona).substring(String.valueOf(idPersona).length()-2));
        factura.setIdFactura(new Integer(s));

        DAOFactory.getInstance().getViewFacturaDAO().create(factura);
        
        for (ViewProductoFactura vpf : productos){
            vpf.setIdFactura(factura.getIdFactura());
            DAOFactory.getInstance().getViewProductoFacturaDAO().create(vpf);
        }
        
    }
}
