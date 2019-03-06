package com.othman.markit.firstscreens.appscreens.groupAndItemsClasses;

import android.media.Image;
import android.widget.ImageButton;

public class ShoppingItem {

    public ImageButton imageButton;
    public String itemName;
    public Image image;

    public ShoppingItem(String itemName,Image image){

    itemName=this.itemName;
    this.image=image;
    }
}
