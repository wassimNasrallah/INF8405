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
    private Bitmap bitmap;

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
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.blue);
                break;
            case "o":;
            case "orange":
                type = ItemTypeEnum.TYPE_ORANGE;
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.orange);
                break;
            case "r":;
            case "red":
                type = ItemTypeEnum.TYPE_RED;
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.red);
                break;
            case "y":;
            case "yellow":
                type = ItemTypeEnum.TYPE_YELLOW;
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.yellow);
                break;
            case "g":;
            case "green":
                type = ItemTypeEnum.TYPE_GREEN;
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.green);
                break;
            case "p":;
            case "purple":
                type = ItemTypeEnum.TYPE_PURPLE;
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.purple);

        }
    }
}
