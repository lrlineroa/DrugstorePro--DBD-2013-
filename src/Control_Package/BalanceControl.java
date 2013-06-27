/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Package;

import DAOS.DAOFactory;
import Entities.Views.ViewConsolidadoAnual;
import Entities.Views.ViewConsolidadoMensual;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class BalanceControl {

    public List<ViewConsolidadoMensual> getSalesForMonth(int year) {
        List<ViewConsolidadoMensual> viewMensual= DAOFactory.getInstance().getViewConsolidadoMensualDAO().findViewConsolidadoMensualEntities(year);
        return viewMensual;
    }

    public List<ViewConsolidadoAnual> getSalesForYear() {
        return DAOFactory.getInstance().getViewConsolidadoAnualDAO().findAll();
    }
    
    
    
    
   
    
}

