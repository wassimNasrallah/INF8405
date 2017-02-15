package com.example.wassim.tp1_inf8405.elements;

import java.util.Random;

/**
 * Created by gamyot on 2017-02-13.
 */

public class ItemHandler {
    private Level level;
    private Random seed;

    public ItemHandler(Level level) {
        this.level = level;

    }

    public void remove(int x, int y) {
        level.getCells()[y][x].putItem(new Item(ItemTypeEnum.TYPE_NONE));
    }

    
    public void respawnRequest(){
        for (int i = 0; i< level.getAmountOfCollumns();i++){
            columnRespawn(i);
        }
    }

    private void columnRespawn(int column){
        if(level.getCells()[column][0].getItem().getType().equals(ItemTypeEnum.TYPE_NONE)){
            int amountOfCells = fillEmptyCells(column);
        }
    }


    /**
     * Check how many
     * @return
     */
    private int fillEmptyCells(int column) {
        int count = 1;
        boolean continueLookingDown = true;
        while(continueLookingDown){
            if(count < level.getAmountOfRows() && level.getCells()[column][count].getItem().getType().equals(ItemTypeEnum.TYPE_NONE)) {
                level.getCells()[column][count].putItem(generateNewItem());
                level.getCells()[column][count].setEmpty(false);
                count++;
            }else{
                continueLookingDown = false;
            }
        }
        return count;
    }



    public Item generateNewItem(){
        return new Item(ItemTypeEnum.values()[seed.nextInt(6)]);
    }


}
