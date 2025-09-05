
/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @author Alexander Loo
 * @version 0.25
 */

import java.util.*;
public class rItem
{
    private int sku;
    private String descrip;
    private boolean taxAble;
    private double msrp;
    private double recyFee;

    public rItem()
    {
        sku = 00000;
        descrip = "none";
        taxAble = false;
        msrp = 0.0;
        recyFee = 0.0;
    }

    public rItem(int aSku, String aDes, boolean aTax, double aMsrp, 
                double arecyFee)
    {
        sku = aSku;
        descrip = aDes;
        taxAble = aTax;
        msrp = aMsrp;
        recyFee = arecyFee;
    }

    public int getSku(){return sku;}
    public String getDes(){return descrip;}
    public boolean getTaxable(){return taxAble;}
    public double getMsrp(){return msrp;}
    public double getRecyfee(){return recyFee;}

    public void setSku(int aSku){sku = aSku;}
    public void setDes(String aDes){descrip = aDes;}
    public void setTaxable(boolean aTax){taxAble = aTax;}
    public void setMsrp(double aMsrp){msrp = aMsrp;}
    public void setRecyfee(double arecyFee){recyFee = arecyFee;}

    private String isTaxable()
    {
        return taxAble ? "T" : " ";
    }
    private void printIdeets()
    {
        System.out.print(sku + "\t" + descrip + "     " + "\t" +  isTaxable());
        System.out.printf("\t" + "%.2f",msrp);
        System.out.println();
    }
    /*
    Fucntion will take in a sku, print the item if found, and return an ArrayList
    with the added item(s) if any.
    
        tArr (temp array) input arraylist
        rArr (return/retail array) output al
    */
    private ArrayList<rItem> mSku(int tSku, ArrayList<rItem> tArr,
                                  ArrayList<rItem> rArr, int idx)
    {
        if(idx < tArr.size())
        {
            if(tSku == tArr.get(idx).getSku())
            {
                rArr.add(tArr.get(idx));
                tArr.get(idx).printIdeets();
                return rArr;
            }
            else
            {
            //++idx;
            return mSku(tSku, tArr, rArr, ++idx);
            }
        }
        else
        {
            System.out.println("Item not found.");
            return rArr;
        }
    }
    
    public ArrayList<rItem> matchSku(int tSku, ArrayList<rItem> tArr,
                                     ArrayList<rItem> rArr)
    {
        mSku(tSku, tArr, rArr, 0);
        return rArr;
    }
    public void printInfo() { printIdeets(); }
}
