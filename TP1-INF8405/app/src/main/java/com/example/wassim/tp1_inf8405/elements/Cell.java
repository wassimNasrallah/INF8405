package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class Cell {
    private Item currentItem;
    private boolean isEmpty;
    private int posX, posY;

    public Cell(int x, int y){
        posX = x;
        posY = y;
        isEmpty = true;
    }

    public Item getItem(){
        return currentItem;
    }

    public void putItem(Item newItem){
        currentItem = newItem;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void setEmpty(){

    }
}
