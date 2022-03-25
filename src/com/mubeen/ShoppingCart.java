package com.mubeen;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Item> items;

    public ShoppingCart(){
        this.items = new ArrayList<Item>();
    }

    public void setItem(Item item, int index) {
        this.items.set(index,new Item(item));
    }

    public Item getItem(int index){
        return new Item(this.items.get(index));
    }

    /**
     * Name: add
     * @param item
     * @return boolean
     *
     * Inside the function:
     *   1. Adds an item to the cart if it wasn't already added.
     */

    public boolean add(Item item){
        if (this.items.contains(item)) {
            return false;
        }
        else{
            this.items.add(new Item(item));
            return true;
        }
    }

    public void remove(String name){

        if(this.items.isEmpty()){
            throw new IllegalStateException("Cart is empty");
        }
        for (int i = 0; i < this.items.size(); i++) {
            if(this.items.get(i).getName().equals(name)){
                this.items.remove(i);
            }
        }
    }

    /**
     *  Name: checkout
     *  @return (String)
     *
     *  Inside the function:
     *   1. Calculates the subtotal (price before tax).
     *   2. Calculates the tax (assume tax is 13%).
     *   3. Calculates total: subtotal + tax
     *   4. Returns a String that resembles a receipt. See below.
     */

    public String checkout(){
        if(this.items.isEmpty()){
            throw new IllegalStateException("Cart is empty");
        }

        double[] measures = new double[3];
        for (int i = 0; i < this.items.size(); i++) {
            measures[0] += this.items.get(i).getPrice();
        }
        measures[1] = measures[0]*0.13;
        measures[2] = measures[0] + measures[1];

        return "\tRECEIPT\n" +
                "\tSubtotal: $" + String.format("%.2f",measures[0])+ "\n" +
                "\tTax: $" + String.format("%.2f",measures[1])+ "\n" +
                "\tTotal: $" + String.format("%.2f",measures[2]) + "\n";
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }
    public String toString(){
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp+="\n";
        }
        return temp;
    }


}
