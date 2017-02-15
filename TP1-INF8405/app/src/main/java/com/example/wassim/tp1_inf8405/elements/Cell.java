package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class Cell {
    private Item currentItem;
    private boolean isEmpty = true;
    private boolean markedToBeDeleted = false;


    public Cell(Item newItem){
        currentItem = newItem;
        isEmpty = false;
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

    public void setEmpty(boolean isEmpty){
        this.isEmpty = isEmpty;
        if(isEmpty == true){
            putItem( new Item(ItemTypeEnum.TYPE_NONE));
        }
    }

    public boolean isMarkedToBeDeleted() {
        return markedToBeDeleted;
    }

    public void setMarkedToBeDeleted(boolean markedToBeDeleted) {
        this.markedToBeDeleted = markedToBeDeleted;
    }
}
