package com.mubeen;

public class Item {

    private String name;
    private double price;

    public Item(String name, double price){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty/null");
        }
        if(price<0.0){
            throw new IllegalStateException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public Item(Item item){
        this.name = item.name;
        this.price = item.price;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty/null");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if(price<0.0){
            throw new IllegalStateException("Price cannot be negative");
        }
        this.price = price;
    }

    public String toString(){
        return " " + this.name + ": "+"$"+ this.price + "\n";
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        if(!(obj instanceof Item)){
            return false;
        }
        Item item = (Item)obj;
        return this.name.equals(item.name) && this.price == item.price;
    }
}
