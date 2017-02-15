package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class Item {
    private ItemTypeEnum type;

    public Item(ItemTypeEnum newType){
        type = newType;
    }
    public ItemTypeEnum getType() {
        return type;
    }
}
