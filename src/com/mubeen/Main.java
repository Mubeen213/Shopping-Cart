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
        ShoppingCart cart = new ShoppingCart();

        cart.add(new Item("Celery", 0.99));

        cart.add(new Item("Celery", 0.99));

        cart.add(new Item("Spinach", 0.99));

        cart.add(new Item("Coriander", 1.29));

        System.out.println(cart.checkout());
        System.out.println(cart);
    }
}
