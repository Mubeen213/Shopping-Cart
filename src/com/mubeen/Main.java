package com.mubeen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *The java store is divided into aisles(rows).
 * Each aisle shelves a category of items.
 * Each item is described by its name and price.
 * The shopping cart holds user's items.
 * The shopping cart lets users add,remove, and check items out.
 */
public class Main {

    static Store store = new Store();
    static ShoppingCart cart = new ShoppingCart();
    public static void main(String[] args) {
	// write your code here
        try{
            loadItems("Resources/products.txt");
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }finally {
            manageItems();
        }

    }

    /**
     * Name: manageItems <------
     * Inside the function:
     *   - 1. Starts a new instance of Scanner;
     *   - 2. Creates an infinite loop:
     *   -        The user can choose to a) add or b) remove c) checkout.
     *   -          case a: asks for the aisle and item number. Then, adds item to cart.
     *   -          case b: asks for the name. Then, removes item from cart.
     *   -          case c: prints the receipt and closes Scanner.
     *   -        Prints the updated shopping cart.
     */
    public static void manageItems(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(("\n\t******************************JAVA GROCERS******************************\n"));
            System.out.println(store);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String response = sc.nextLine();
            switch (response){
                case "a":
                    System.out.print("\nChoose an aisle(row) number between: 1 – 7: ");
                    int row = sc.nextInt()-1;
                    sc.nextLine();
                    System.out.print("Choose an item number between: 1 – 3: ");
                    int col = sc.nextInt()-1;
                    sc.nextLine();
                    Item item = new Item(store.getItem(row,col));
                    if(cart.add(item)){
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    }else{
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }
                    break;
                case "b":
                    System.out.print("Enter the item you'd like to remove: ");
                    String name = sc.nextLine();
                    cart.remove(name);
                    break;
                case "c":
                    System.out.println(cart.checkout());
                    break;
            }
        }
    }
    public static void loadItems(String fileName) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream(fileName);
        Scanner sc = new Scanner(fis);
        for(int i=0 ; sc.hasNextLine(); i++){
            String line = sc.nextLine();
            String[] items = line.split(";");
            for (int j = 0; j < items.length; j++) {
                String[] fields = items[j].split("=");
                store.setItem(new Item(fields[0], Double.parseDouble(fields[1])), i, j);
            }
        }
        sc.close();
    }
}
