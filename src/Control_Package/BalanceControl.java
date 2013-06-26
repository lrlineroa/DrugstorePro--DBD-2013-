/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_Package;

import DAOS.DAOFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utilities.sales.SalesForMonth;
import utilities.sales.SalesForWeek;
import utilities.sales.SalesForYear;

/**
 *
 * @author User
 */
public class BalanceControl {
    private SalesForWeek week=new SalesForWeek();
    private Integer price;
    Date dateInit;
    Date dateEnd;
    private List<SalesForWeek> theFourWeeks=new ArrayList<SalesForWeek>();
    private int[] DaysofMonths={31,30,28,31,30,31,30,31,31,30,31,30,31};
    public List<SalesForMonth> findTotalSalesForMonth(Integer year){
       return (List<SalesForMonth>) DAOFactory.getInstance().getViewFacturaDAO().findTotalSalesForMonth(year);
    }

    public List<SalesForYear> findSalesForYear(Integer yearInit,Integer yearEnd) {
        return (List<SalesForYear>)  DAOFactory.getInstance().getViewFacturaDAO().findTotalSalesForYear(yearInit,yearEnd);
    }
    
    public List<SalesForWeek> findSalesForWeek(Integer month,Integer year){
        
        if(DaysofMonths[month]==31){
            int i=1;
            while(i<31){
               if(i!=25){
                   int[] days={i,i+7};
                   price=DAOFactory.getInstance().getViewFacturaDAO().findSalesForWeek(new Date(year,month, i), new Date(year, month, i+7));
                   week.setWeek(days);
                   if(price == null){
                       week.setTotalPrice(0);
                   }    
                   week.setTotalPrice(price);
                   theFourWeeks.add(week);
                   i=i+8; 
               }else{
                   int[] days={25,31};
                   price=DAOFactory.getInstance().getViewFacturaDAO().findSalesForWeek(new Date(year,month, 25), new Date(year,month, 31));
                   week.setWeek(days);
                   if(price == null){
                       week.setTotalPrice(0);
                   }    
                   week.setTotalPrice(price);
                   theFourWeeks.add(week);
               }
            }
            return theFourWeeks;
        }else if(DaysofMonths[month]==30){
            int i=1;
            while(i<30){
               if(i!=25){
                   int[] days={i,i+6};
                   price=DAOFactory.getInstance().getViewFacturaDAO().findSalesForWeek(new Date(year,month, i),new Date(year,month, i+6));
                   week.setWeek(days);
                   if(price == null){
                       week.setTotalPrice(0);
                   }    
                   week.setTotalPrice(price);
                   theFourWeeks.add(week);
                   i=i+7; 
               }else{
                   int[] days={22,30};
                   price=DAOFactory.getInstance().getViewFacturaDAO().findSalesForWeek(new Date(year,month, 22), new Date(year,month, 30));
                   week.setWeek(days);
                   if(price == null){
                       week.setTotalPrice(0);
                   }    
                   week.setTotalPrice(price);
                   theFourWeeks.add(week);
                   
               }
            }
            return theFourWeeks;
        }else{
            int i=1;
            while(i<28){
               int[] days={i,i+6};
               price=DAOFactory.getInstance().getViewFacturaDAO().findSalesForWeek(new Date(year,month, i),new Date(year,month, i+6));
               week.setWeek(days);
                   if(price == null){
                       week.setTotalPrice(0);
                   }    
                   week.setTotalPrice(price);
                   theFourWeeks.add(week);
                   i=i+7;
               i=i+7; 
               
            }
            return theFourWeeks;
        }  
        
    }
    
}

