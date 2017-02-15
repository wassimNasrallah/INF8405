package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class ItemHandler {
    private Level level;

    public ItemHandler(Level level) {
        this.level = level;

    }

    public void fall(){

    }



    public void remove(int x, int y) {
        level.getCells()[x][y].putItem(new Item(ItemTypeEnum.TYPE_NONE));
    }

    public void respawnRequest(){
        for (int i = 0; i< level.getAmountOfCollumns();i++){
            columnRespawn(i);
        }
    }

    private void columnRespawn(int column){
        if(level.getCells()[0][column].getItem().getType().equals(ItemTypeEnum.TYPE_NONE)){
            int amountOfCells = checkAmountOfEmptyCells(column);
        }
    }

    /**
     * Check how many
     * @return
     */
    private int checkAmountOfEmptyCells(int column) {
        int count = 1;
        boolean continueLookingDown = true;
        while(continueLookingDown){
            if(count < level.getAmountOfRows() && level.getCells()[count][column].getItem().getType().equals(ItemTypeEnum.TYPE_NONE)) {
                count++;
            }else{
                continueLookingDown = false;
            }
        }
        return count;
    }


}
