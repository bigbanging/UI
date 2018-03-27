package com.litte.ui.bean;

/**
 * Created by litte on 2018/3/23.
 */

public class Item {
    private int item_icon;
    private String item_name;

    public Item() {
    }

    public Item(int item_icon, String item_name) {
        this.item_icon = item_icon;
        this.item_name = item_name;
    }

    public int getItem_icon() {
        return item_icon;
    }

    public void setItem_icon(int item_icon) {
        this.item_icon = item_icon;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
