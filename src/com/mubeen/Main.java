package com.mubeen;

/**
 *The java store is divided into aisles(rows).
 * Each aisle shelves a category of items.
 * Each item is described by its name and price.
 * The shopping cart holds user's items.
 * The shopping cart lets users add,remove, and check items out.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here

        Item item = new Item("Coffee",2.1);
        Item item2 = new Item(item);
                item2.setPrice(1.1);
        System.out.println(item);
        System.out.println(item2);

    }
}
