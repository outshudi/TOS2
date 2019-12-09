////////////////////////////////////////////////////////////////////
// [Olivier] [Utshudi] [1143556]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.business.itemType;

public class MenuItem {
    public itemType type;
    public String name;
    public double price;

    public MenuItem(itemType type, String name, double price){
        this.type= type;
        this.name= name;
        this.price= price;
    }
    
    public MenuItem(MenuItem item) {
        this.type= item.type;
        this.name= item.name;
        this.price= item.price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public itemType getType() {
        return type;
    }
}
