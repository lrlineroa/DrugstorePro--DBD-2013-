/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.sales;

/**
 *
 * @author User
 */
public class SalesForWeek {
    //this attribute week saves the initDay an EndDay for a dummy week (the month divide into four parts almost equal)
    private int[] Week=new int[2];
    private int TotalPrice;

    /**
     * @return the Week
     */
    public int[] getWeek() {
        return Week;
    }

    /**
     * @param Week the Week to set
     */
    public void setWeek(int[] Week) {
        this.Week = Week;
    }

    /**
     * @return the TotalPrice
     */
    public int getTotalPrice() {
        return TotalPrice;
    }

    /**
     * @param TotalPrice the TotalPrice to set
     */
    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
}
