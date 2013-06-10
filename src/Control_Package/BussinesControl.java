/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Package;

import DAOS.DAOFactory;
import Entities.Views.ViewMedicamento;
import Entities.Views.ViewPedido;
import java.util.List;

/**
 * 
 * @author lrlineroa
 *  this Class contains all the controllers that refers to the principle of the bussines
 *  such as sell inventary, and query of products on the pharmacy, or orders.
 */
public class BussinesControl {
    // this method returns a Product with a specific ID given
    public ViewMedicamento MakeQuery(Long Id){
        return DAOFactory.getInstance().getViewMedicamentoDAO().findViewMedicamento(Integer.parseInt(""+Id));
    }
    
    // this method returns a Order with a specific ID given
    public ViewPedido MakeQuery(Integer ID){
        return DAOFactory.getInstance().getViewPedidoDAO().findViewPedido(ID);
    }
    
    //this method returns a list of productos such name is like the given.
    public List<ViewMedicamento> MakeQuery(String name){
         return DAOFactory.getInstance().getViewMedicamentoDAO().findViewMedicamento(name);
    }
    
    // this method returns a specific  product with a ID a name given
    public ViewMedicamento MakeQuery(Integer ID,String name){
        return DAOFactory.getInstance().getViewMedicamentoDAO().findViewMedicamento(ID, name);
    }
    
    //this method make a sell of a specific product
    public int MakeSell(Long Id, Object amount){
     return DAOFactory.getInstance().getViewMedicamentoDAO().Update(Id, amount, false);   
    }
    
    //this method make a inventary of a specific product
    public int MakeInventary(Long Id, Object amount){
     return DAOFactory.getInstance().getViewMedicamentoDAO().Update(Id, amount, true);   
    }
    
}
