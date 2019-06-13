package com.othman.markit.firstscreens.groupAndItemsClasses;

import android.media.Image;

public class ShoppingItem {


    public String itemName;
    public int itemAmount;

    public ShoppingItem(String itemName,Image image){

    itemName=this.itemName;
    itemAmount=this.itemAmount;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
