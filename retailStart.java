
/**
 * This class will initialize the a Retail or Restaurant transaction
 *
 * @author  Alexander Loo
 * @version 0.25
 */

import java.util.*;
public class retailStart 
{
    static Scanner in = new Scanner(System.in);
    
    public static void retail()
    {
        rItem r1 = new rItem();
        ArrayList<rItem> cartArr = new ArrayList<>();
        
        RetailTransaction Target = new RetailTransaction("Target", 
        "3030 Grape Street", "San Diego, CA 92102", "Welcome to Target",
        "Help make your Target Run better.", "", 6196847086L, 000, 0, 7.75,
        cartArr, .10, 0.0, 0.0);
        
        // item inventory
        rItem cloth1 = new rItem(55001, "Hanes usft 6 pr", true, 8.99, 0.0);
        rItem cloth2 = new rItem(55002, "Champion T-shirt M", true, 11.99, 0.0);
        rItem bev1 = new rItem(12001, "Coca-Cola 20oz", false, 1.99, 0.10);
        rItem bev2 = new rItem(12002, "Sprite 2Ltr", false, 2.79, 0.10);
        rItem toy1 = new rItem(37001, "Star Wars Lego set", true, 34.99, 0.0);
        rItem toy2 = new rItem(37002, "Polly Pocket set", true, 47.95, 0.0);
        rItem dev1 = new rItem(51001, "iPad Pro 12\"" , true , 999.99, 3.00);
        rItem dev2 = new rItem(51002, "Samsung Tab S6" , true , 549.99, 3.00);
        
        ArrayList<rItem> reVntry = new ArrayList<>
            (
                Arrays.asList
                (
                    bev1, bev2, cloth1, cloth2, toy1, toy2, dev1, dev2
                )
            );
        
        boolean itemsFound = false;
        System.out.println("Press a Command");
        System.out.println("(E)nter Items, (T)otal, (Q)uit: ");
        while(!itemsFound)
        {

            String userCmd = in.next();
            char command = userCmd.charAt(0);
            switch(command)
            {
                case 'E':
                case 'e':
                    System.out.print("Sku number: ");
                    int inSku = in.nextInt();
                    r1.matchSku(inSku, reVntry, cartArr);
                    break;
                
                case 'T':
                case 't':
                    Target.checkout(cartArr);   // calls retailTrans method
                    Target.startReceipt();     // calls retailTrans, initialize receipt
                    itemsFound = true;
                    break;
                    
                case 'Q':
                case 'q':
                    itemsFound = true;
                    break;
                    
                default:
                    System.out.println("Command not recognized.");
            }
        }
    }
    public static void rest()
    {
        System.out.println("Restaurant module");
    }
    public static void main(String args[])
    {
        retail();
    }
}
