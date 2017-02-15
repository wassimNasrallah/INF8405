package com.example.wassim.tp1_inf8405.elements;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.wassim.tp1_inf8405.R;

import static com.example.wassim.tp1_inf8405.elements.MapXmlLoader.context;

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
    public Item(String stringType){
        switch (stringType){
            case "b":;
            case "blue":
                type = ItemTypeEnum.TYPE_BLUE;
                break;
            case "o":;
            case "orange":
                type = ItemTypeEnum.TYPE_ORANGE;
                break;
            case "r":;
            case "red":
                type = ItemTypeEnum.TYPE_RED;
                break;
            case "y":;
            case "yellow":
                type = ItemTypeEnum.TYPE_YELLOW;
                break;
            case "g":;
            case "green":
                type = ItemTypeEnum.TYPE_GREEN;
                break;
            case "p":;
            case "purple":
                type = ItemTypeEnum.TYPE_PURPLE;

        }
    }
}
