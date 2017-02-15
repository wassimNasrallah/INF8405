package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class SwapController {
    private Level level;

    public SwapController(Level level){
        this.level = level;
    }

    /***
     * Swap the items of two adjacent cells
     * @param cell1
     * @param cell2
     */
    public boolean swap(int cell1X,int cell1Y,int cell2X, int cell2Y){
        if(!(cell1Y < level.getAmountOfRows()
                && cell2Y < level.getAmountOfRows()
                && cell1X < level.getAmountOfCollumns()
                && cell2X < level.getAmountOfCollumns())){
            return false;
        }

        Cell cell1 = level.getCells()[cell1Y][cell1X];
        Cell cell2 = level.getCells()[cell2Y][cell2X];

        boolean isSucces = false;
        if(cell1.isEmpty() || cell2.isEmpty()){
            isSucces = false;
        }
        else if (!isSwapAllowed( cell1X, cell1Y, cell2X,  cell2Y)){
            isSucces = false;
        } else{
            Item tempItem = cell1.getItem();
            cell1.putItem(cell2.getItem());
            cell2.putItem(tempItem);
            isSucces = true;
        }
        return isSucces;
    }

    /***
     * A swap is allowed only between horisontaly and verticaly adjacent cells
     * @return
     */
    private boolean isSwapAllowed(int cell1X,int cell1Y,int cell2X, int cell2Y){
        return (Math.pow(cell1X - cell2X,2) + Math.pow(cell1Y - cell2Y,2))==1;
    }

}
