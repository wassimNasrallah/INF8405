package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

import java.util.Random;
public class ItemFactory {
    private Random seed;

    public Item generateNewItem(){
        return new Item(ItemTypeEnum.values()[seed.nextInt(6)]);
    }
}
