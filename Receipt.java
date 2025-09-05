/**
 * Write a description of class Receipt here.
 *
 * @author  Alexander Loo
 * @version 0.25
 */

import java.util.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Receipt
{
    private JPanel panel;
    private JComponent component;
    //Scanner in = new Scanner(System.in);
    /*
    public Receipt()
    {
        panel = new JPanel();
        component = new ReceiptComponent();
        component.setPreferredSize(new Dimension(380, 725 +(getItemlist().size() * 2)));
        panel.add(component);
        add(panel);
        
        setTitle("Sample Receipt");
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //left off here transfer main receipt methods from trans calss
    //continue code, x marks the spot
    class ReceiptComponent extends JComponent
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            // Remove comments below after transfering code to nbeans
            //DecimalFormat df = new DecimalFormat("#.00");
            Font nf = new Font(Font.SANS_SERIF, Font.BOLD, 13);
            g.setFont(nf);
            
            int y = 50;
            int x = 18;
            int Lidx = 0;
            g.setColor(Color.BLACK);
            g.drawString(getDba(), (getWidth()/2) - getDba().length()*3, y);
            g.drawString(getAddress(), (getWidth()/2) - getAddress().length()*3, y+=12);
            g.drawString(getCityz(), (getWidth()/2) - getCityz().length()*3, y+=14);
            g.drawString(l2s(getPhone()),(getWidth()/2) - l2s(getPhone()).length()*4, y+=14);
                y+=36;
            while(Lidx < getItemlist().size())
                {
                    g.drawString(l2s(getItemlist().get(Lidx).getSku()) , x , y);
                    g.drawString(getItemlist().get(Lidx).getDes() , x+=54 , y);
                    g.drawString(getItemlist().get(Lidx).getTaxable()? "T" : " ",
                        getWidth()/2 + 108, y);
                    g.drawString(addMon(getItemlist().get(Lidx).getMsrp()),
                        getWidth()-(18 + addMon(getItemlist().get(Lidx).getMsrp()).length()*6),
                        y);
                    ++Lidx;
                    y+=14;
                    x = 18;
                }
            g.drawString(addMon(getInvsubtotal()), getWidth()-(18
                    + addMon(getInvsubtotal()).length()*6), y+=28);
            g.drawString("SUBTOTAL", getWidth()-(18+addMon(getInvsubtotal()).length()*20),
                    y);
                    
            g.drawString(addMon(getTaxamt()), getWidth()-(18 + addMon(getTaxamt()).length()*6),
                    y+=14);
            g.drawString("TAX " + addTax(getTaxrate()), getWidth()
                    -(18+addMon(getInvsubtotal()).length()*20), y);

            g.drawString(addMon(getInvtotal()), getWidth()-(18
                    + addMon(getInvtotal()).length()*6), y+=14);
            g.drawString("TOTAL", getWidth()-(18+addMon(getInvsubtotal()).length()*20),
                    y);
            //Draw ground
            g.setColor(Color.GRAY);
            g.fillRect(0, 680, 380, 125);
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
    public static void startReceipt()
    {
        //**Prompt type of receipt here
        //Change this to the custom dialog prompt
        // set invCopy to "Merchant" or "Customer"
        // method will create merchant receipt copies
        // and conditionally create a customer receipt
        
        //See Snowman's main for 2 window creation, i.e:
        Receipt r1 = new Receipt();
        r1.setVisible(true);
    }*/
}
