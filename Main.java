import models.Item;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import models.Cart;
import models.Store;

public class Main {
    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void main(String[] args) {
        try {
            loadItems("products.txt");
            manageItems();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
       
        
        
    }

    /**
     * Name: manageItems
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. Creates an infinite loop:     
     *   •        The user can choose to a) add or b) remove c) checkout.
     *   •          case a: asks for the aisle and item number. Then, adds item to cart.
     *   •          case b: asks for the name. Then, removes item from cart.
     *   •          case c: prints the receipt and closes Scanner.
     *   •        Prints the updated shopping cart.
     */

     public static void manageItems() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String response = scan.nextLine();
            if (response.equals("a")) {
                System.out.print("\nChoose an aisle number between: 1 - 7: ");
                int row = scan.nextInt();
                if (row > 7 || row < 0) {
                    continue;
                }
                scan.nextLine();
                row -=1;
                System.out.print("Choose an item number between: 1 - 3: ");
                int column = scan.nextInt();
                if (column > 3 || column < 0) {
                    continue;
                }
                scan.nextLine();
                column -= 1;
                Item item = store.getItems(row, column);
                if (cart.add(item)) {
                    System.out.println(item.getName() + " was added to your shopping cart.");
                }else {
                    System.out.println(item.getName() + " is already in your shopping cart.");
                }
            } else if (response.equals("b")) {
                if (cart.isEmpty()) {
                    continue;
                }
                System.out.print("Enter the item you'd like to remove: ");
                cart.remove(scan.nextLine());
            } else if (response.equals("c")) {
                if (cart.isEmpty()) {
                    continue;
                }
                System.out.println(cart.checkout());
            } else {
                continue;
            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("Enter anything to continue: ");
            scan.nextLine();
        }
     }
 

    /**
     * Name: loadItems
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   1. loads items from <fileName>.txt.
     *      • while loop runs through every line in <fileName>
     *      • scan.nextLine() picks up the entire line.
     *      • splits each String using the ";" separator.
     *      • splits both fields in each String using the "=" separator.
     *      • Parse each price into a Double.
     *   2. adds all items to the store object's items field.
     */

     public static void loadItems(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);
        
        
            for (int i = 0; scanFile.hasNextLine(); i++) {
                String line = scanFile.nextLine();
                String[] fields = line.split(";");
                for (int j = 0; j < fields.length; j++) {
                    String name = fields[j].split("=")[0];
                    System.out.println(name);
                    double price = Double.parseDouble(fields[j].split("=")[1]);
                    store.setItem(i, j, new Item(name, price));
                }
            }
            scanFile.close();
           
              
            
            
        }
        
     }


