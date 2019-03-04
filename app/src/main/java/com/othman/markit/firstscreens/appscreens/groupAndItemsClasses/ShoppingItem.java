package com.othman.markit.firstscreens.appscreens.groupAndItemsClasses;

import android.media.Image;
import android.widget.ImageButton;

public class ShoppingItem {
  public static   int price;
    public ImageButton imageButton;
    public String itemName;
    public Image image;

    public ShoppingItem(int price,String itemName,Image image){
    price=this.price;
    itemName=this.itemName;
    this.image=image;
    }
}
