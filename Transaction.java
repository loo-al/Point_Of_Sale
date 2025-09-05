/**
 * Super class before polymorphism
 * This is the general Transaction class
 *
 * @author  Alexander Loo
 * @version 0.25
 */
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Transaction extends JFrame
{
    private JPanel panel;
    private JComponent component; 
    
    private String dba, bizAddress, cityZip;
    private String payType, brandAsso;
    private String invCopy;             // Receipt type, merchant/cust copy
    private String webMsg, customMsg;   // may have footerMsg later 
    private String itemDescrip;
    private String custName;

    private int locationNum;
    private int authCode;
    private int invItems;               // # of items
    private int last4;                  // truncated card #
    private int invNum;
    private int transNum;

    private long phoneNum;
    private long aID;
    private long cardNum;
    private double taxRate, taxAmt;
    private double changeRemain;
    private double invSubtotal, invTotal, invBalance;
    private double discountRate;
    private double discountAmt;

    private boolean transApprove;
    private ArrayList<rItem> itemList;

    static Scanner in = new Scanner(System.in);
    private JPanel drawPanel;
    private JButton button;

    // Default constructor (29 inst. var.)
    public Transaction()
    {
        dba = "noDba"; bizAddress = "noAddr"; cityZip = "noCitZ";
        payType = "noPayty"; brandAsso = "noBrandA";
        invCopy = "noInvcopy";
        webMsg = "noWebm"; customMsg = "noCusmsg";
        itemDescrip = "noItminfo";
        custName = "noName";
        //10
        invNum = 12345;
        locationNum = 123;
        invItems = 00;
        authCode = 012345;
        transNum = 4321;
        last4 = 1234;
        //6
        phoneNum = (int)1234567890L;
        aID = (int)1234567890123L;
        cardNum = (int)1234567890123456L;
        //3
        taxRate = 1.0; taxAmt = 0.0;
        changeRemain = 0.0;
        invSubtotal = 0.0; invTotal = 0.0; invBalance = 0.0;
        discountRate = 0.0; discountAmt = 0.0;
        //8
        transApprove = false;
        //1
        itemList = new ArrayList<>();
    }
    // Overloaded with 9 parameters
    public Transaction(String aDba, String anAddr, String aCity, String aWeb,
    String aCustom, int aLocationnum, long aPhone, 
    double aTaxrate, ArrayList<rItem> anItemList)
    {
        //parameter list
        dba = aDba; bizAddress = anAddr; cityZip = aCity;
        webMsg = aWeb; customMsg = aCustom;
        locationNum = aLocationnum;
        phoneNum = aPhone;
        taxRate = aTaxrate;
        itemList = anItemList;

        payType = "noPayty"; brandAsso = "noBrandA";
        invCopy = "noInvcopy";
        itemDescrip = "noItminfo";
        custName = "noName";

        invNum = 12345;
        invItems = 00;
        authCode = 012345;
        transNum = 4321;
        last4 = 1234;

        aID = (int)1234567890123L;
        cardNum = (int)1234567890123456L;

        taxAmt = 0.0;
        changeRemain = 0.0;
        invSubtotal = 0.0; invTotal = 0.0; invBalance = 0.0;
        discountRate = 0.0; discountAmt = 0.0;

        transApprove = false;
    }
    // Accessors
    public String getDba(){return dba;}
    public String getAddress(){return bizAddress;}
    public String getCityz(){return cityZip;}
    public String getWebmsg(){return webMsg;}
    public String getCustmsg(){return customMsg;}
    public String getPaytype(){return payType;}
    public String getBrandA(){return brandAsso;}
    public String getInvcopy(){return invCopy;}
    public String getItemdes(){return itemDescrip;}
    public String getCustname(){return custName;}
    public int getLocationnum(){return locationNum;}
    public long getPhone(){return phoneNum;}
    public int getAuthcode(){return authCode;}
    public int getTransnum(){return transNum;}
    public int getLast4(){return last4;}
    public long getAid(){return aID;}
    public long getCardnum(){return cardNum;}
    public double getTaxrate(){return taxRate;}
    public double getTaxamt(){return taxAmt;}           
    public double getChangeamt(){return changeRemain;}
    public double getInvsubtotal(){return invSubtotal;}
    public double getInvtotal(){return invTotal;}
    public double getIvnbalance(){return invBalance;}
    public double getDiscountrate(){return discountRate;}
    public double getDiscountamt(){return discountAmt;}
    public boolean getTransapprove(){return transApprove;}
    public ArrayList<rItem> getItemlist(){return itemList;}
    // Modifiers
    public void setPaytype(String payTy){payType = payTy;}
    public void setBranda(String sBrand){brandAsso = sBrand;}
    public void setInvcopy(String sInvcopy){brandAsso = sInvcopy;}
    public void setItemdes(String sItemdes){itemDescrip = sItemdes;}
    public void setCustname(String sCustname){custName = sCustname;}
    public void setLocation(int sLocation){locationNum = sLocation;}
    public void setPhone(int sPhone){phoneNum = sPhone;}
    public void setAuthcode(int sAuth){authCode = sAuth;}
    public void setTransnum(int sTrans){transNum = sTrans;}
    public void setLast4(int sLast){last4 = sLast;}
    public void setAid(long sAid){aID = sAid;}
    public void setCardnum(long sCard){cardNum = sCard;}
    public void setTaxrate(double sTaxrt){taxRate = sTaxrt;}
    public void setTaxamt(double sTaxamt){taxAmt = sTaxamt;}
    public void setChangeamt(double sChange){changeRemain = sChange;}
    public void setInvsubt(double sInvsub){invSubtotal = sInvsub;}
    public void setInvtotal(double sInvtot){invTotal = sInvtot;}
    public void setInvbalance(double sInvbal){invBalance = sInvbal;}
    public void setDiscountrate(double sDisrt){discountRate = sDisrt;}
    public void setDiscountamt(double sDisamt){discountAmt = sDisamt;}
    public void setTransapprove(boolean sTransappr){transApprove = sTransappr;}
    public void setItemlist(ArrayList<rItem> sItmlist){itemList = sItmlist;}
    //private methods
    private void applyDiscount()
    {
        calcDiscount();
        invTotal = invSubtotal - discountAmt;
    }
    private void calcChange()
    {
        changeRemain = invBalance * (-1);
    }
    private void calcDiscount()
    {
        discountAmt = invSubtotal * discountRate;   
    }
    private void calcTax()
    {
        taxAmt = invSubtotal * (taxRate/100);   
    }
    private void overrideAmt(double inputAmt)
    {
        invBalance -= inputAmt;
    }
    private void payApproved()
    {
        System.out.println("Thank you for your payment!" + "\n");
    }
    private void pTots()
    {
        System.out.print("     " + "\t" + "          " + "\t");
        System.out.print("SUBTOTAL" + "\t");
        System.out.printf("%.2f",invSubtotal);  System.out.println();
        System.out.print("     " + "\t" + "          " + "\t");
        System.out.print("TAX" + "     " + "\t");
        System.out.printf("%.2f",taxAmt);       System.out.println();
        System.out.print("     " + "\t" + "          " + "\t");
        System.out.print("TOTAL" + "     " + "\t");
        System.out.printf("%.2f",invTotal);     System.out.println();
    }

    //public methods
    public void calcBalance()
    {
        invBalance = invTotal;
        // fundAccount pending more code...
        // for now method will assume payment clears
        payApproved();
    }
    public void calcInvtotal()
    {
        calcTax();
        invTotal = invSubtotal + taxAmt;
        calcBalance();
    }
    public void oCalctax(double tempPrice)
    {
        taxAmt += (tempPrice * (taxRate/100));
        //taxAmt = df.format(taxAmt)
    }

    //may move this to RestaurantTransaction
    public void pay(double inputPaymt)
    {       
        invBalance -= inputPaymt;
    } 
    public void printTotals() { pTots(); }
    public void tranSubtot(double tSub)
    {
        invSubtotal += tSub;
    }

    // Receipt Component
    public void Receipt()
    {
        panel = new JPanel();
        component = new receiptComponent();
        component.setPreferredSize(new Dimension(380, 725 +(getItemlist().size() * 2)));
        panel.add(component);
        add(panel);
        
        setTitle("Sample Receipt");
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
        class receiptComponent extends JComponent
        {
            public void paintComponent(Graphics g)
            {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                int y = 50;
                int x = 18;
                int Lidx = 0;
                Font nf = new Font(Font.SANS_SERIF, Font.BOLD, 13);
                g.setFont(nf);
                
                g.setColor(Color.BLACK);
                g.drawString(dba, (getWidth()/2) - dba.length()*3, y);
                g.drawString(bizAddress, (getWidth()/2) - bizAddress.length()*3, y+=12);
                g.drawString(cityZip, (getWidth()/2) - cityZip.length()*3, y+=14);
                g.drawString(l2s(phoneNum),(getWidth()/2) - l2s(phoneNum).length()*4, y+=14);
                y+=36;
                
                while(Lidx < itemList.size())
                {
                    g.drawString(l2s(itemList.get(Lidx).getSku()) , x , y);
                    g.drawString(itemList.get(Lidx).getDes() , x+=54 , y);
                    g.drawString(itemList.get(Lidx).getTaxable()? "T" : " ",
                        getWidth()/2 + 108, y);
                    g.drawString(addMon(itemList.get(Lidx).getMsrp()),
                        getWidth()-(18 + addMon(itemList.get(Lidx).getMsrp()).length()*6),
                        y);
                    ++Lidx;
                    y+=14;
                    x = 18;
                }
                g.drawString(addMon(invSubtotal), getWidth()-(18
                    + addMon(invSubtotal).length()*6), y+=28);
                g.drawString("SUBTOTAL", getWidth()-(18+addMon(invSubtotal).length()*20),
                    y);
                    
                g.drawString(addMon(taxAmt), getWidth()-(18 + addMon(taxAmt).length()*6),
                    y+=14);
                g.drawString("TAX " + addTax(taxRate), getWidth()
                    -(18+addMon(invSubtotal).length()*20), y);
        
                g.drawString(addMon(invTotal), getWidth()-(18
                    + addMon(invTotal).length()*6), y+=14);
                g.drawString("TOTAL", getWidth()-(18+addMon(invSubtotal).length()*20),
                    y);

            }   
        }
    private String addMon(double tDub)
    {   
        String s1 = "$";
        String s2 = String.format("%.2f", tDub);
        s1 += s2;
        return s1;
    }
    private String l2s(long tInt)
    {
        long a = tInt;
        String s1 = Long.toString(a);
        return s1;
    }
    private String addTax(double tDub)
    {   
        String s1 = "%";
        String s2 = String.format("%.2f", tDub);
        s1 = s2 + s1;
        return s1;
    }
    public void startReceipt()
    {
        //**Prompt type of receipt here
        //Change this to the custom dialog prompt
        // set invCopy to "Merchant" or "Customer"
        // method will create merchant receipt copies
        // and conditionally create a customer receipt
        
        //See Snowman's main for 2 window creation, i.e:
        Receipt r1 = new Receipt();
        Receipt();
        setVisible(true);
    }
}