package com.mubeen;

public class Store {

    private Item[][] items;

    public Store(){
        this.items = new Item[7][3];
    }

    public Item getItem(int row, int col){
        return new Item(this.items[row][col]);
    }

    public void setItem(Item item, int row, int col){
        this.items[row][col] = new Item(item);
    }

    public String toString(){
        String temp = "";
        for (int i = 0; i < this.items.length; i++) {
            switch (i) {
                case 0: temp += "\tDRINKS:        "; break;
                case 1: temp += "\tCEREAL:        "; break;
                case 2: temp += "\tDAIRY:         "; break;
                case 3: temp += "\tDELI:          "; break;
                case 4: temp += "\tGREENS:        "; break;
                case 5: temp += "\tCLOTHING:      "; break;
                case 6: temp += "\tELECTRONICS:   "; break;
            }
            for (int j = 0; j < this.items[i].length; j++) {
                temp += this.items[i][j].toString();
            }
            temp += "\n\n";
        }
        temp +="\t**************************************************************************";
        return temp;
    }
}
