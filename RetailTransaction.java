
/**
 * Subclass of Transaction tailored for retail transcactions
 *
 * @author  Alexander Loo
 * @version 0.25 
 */

import java.util.*;

public class RetailTransaction extends Transaction
{
    private String cashierName;
    private int bagNum;
    private double bagPrice;
    private double invSubnotax;
    private double feeAmt;                  // crv/elec screen fee
    private ArrayList<rItem> itemList;
    
    public RetailTransaction()
    {
        super();
        cashierName = "noName";
        bagNum = 0;
        bagPrice = 0.0;
        invSubnotax = 0.0;
        feeAmt = 0.0;
        //itemList = new ArrayList<>();
    }
    // overloaded construc has 14 parameters
    public RetailTransaction(String aDba, String anAddr, String aCity, 
            String aWeb, String aCustom, String aCashname, long aPhone,
            int aLocationnum, int aBagnum, double aTaxrate, ArrayList<rItem> anItemList
            ,double aBagprice, double aSubnt, double aFeeamt)
    {
        super(aDba, anAddr, aCity, aWeb, aCustom, aLocationnum, aPhone, aTaxrate,
        anItemList);
        cashierName = aCashname;
        bagNum = aBagnum;
        bagPrice = aBagprice;
        invSubnotax = aSubnt;
        feeAmt = aFeeamt;
        //itemList = anItemList;
    }
    
    public String getCashName(){return cashierName;}
    public int getBagnum(){return bagNum;}
    public double getBagprice(){return bagPrice;}
    public double getInvSubnotax(){return invSubnotax;}
    public double getFeeamt(){return feeAmt;}
    //public ArrayList<rItem> getItemlist(){return itemList;}
    
    public void setCashName(String sCashname){cashierName = sCashname;}
    public void setBagnum(int sBagnum){bagNum = sBagnum;}
    public void setInvsubnotax(double aSubnt){ invSubnotax = aSubnt;}
    public void setFeeamt(int sFee){ feeAmt = sFee;}
    public void setBagprice(double sBagprice){bagPrice = sBagprice;}
    //public void setItemlist(ArrayList<rItem> sItmlist){itemList = sItmlist;}
    
    private void bagTax()
    {
        feeAmt += (bagNum * bagPrice);
    }
    /*
    Function takes in ArrayList of rItems; adds their taxable and non-tax
    items, totals them, then displays everything recursively
        cArray = cartArray
    */
    private void check(int idx)
    {
        if(getItemlist().isEmpty())
        {
            System.out.println("There are no items to total.");
        }
        else{
            if(idx >= getItemlist().size())    // (base case)
            {
                setInvsubt(invSubnotax + getInvsubtotal());
                setInvtotal(getInvsubtotal() + getTaxamt() + feeAmt);
                calcBalance();
                //printReceipt();
                // calc subtotal, taxAmt, and Total.
                // Transactin class meth set invBalance, print receipt.
            }
            else
            {
                if(bagNum > 0)
                    bagTax();
                if(getItemlist().get(idx).getRecyfee() > 0) {
                    feeAmt += getItemlist().get(idx).getRecyfee();
                    //add recyFee to feeAmt
                }
                if(getItemlist().get(idx).getTaxable())
                {
                    tranSubtot(getItemlist().get(idx).getMsrp());
                    oCalctax(getItemlist().get(idx).getMsrp());
                    //add msrp to invSubtotal
                    //calc tax on msrp then add to taxAmt
                    check(++idx);
                }
                else
                {
                    invSubnotax += getItemlist().get(idx).getMsrp();
                    //add msrp to invSubnotax
                    check(++idx);
                }
            }
        }
    }
    
    public void checkout(ArrayList<rItem> tempArray)
    {
        // handle bag request after touch event here
        setItemlist(tempArray); // cArray becomes class' main array
        check(0);
    } 
}
