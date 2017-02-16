package com.example.wassim.tp1_inf8405.elements;

import java.util.List;

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
    public int swap(int cell1X,int cell1Y,int cell2X, int cell2Y){
        if(!(cell1Y < level.getAmountOfRows()
                && cell2Y < level.getAmountOfRows()
                && cell1X < level.getAmountOfCollumns()
                && cell2X < level.getAmountOfCollumns())){
            return 0;
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

        int swapPoints = 0;
        if (isSucces) {
            MatchFinder matchFinder = new MatchFinder(level);

            List<MatchResult> matchResultList = matchFinder.findMatches();
            if (matchResultList.size() < 1) {
                isSucces = false;
                //unswap
                Item tempItem = cell1.getItem();
                cell1.putItem(cell2.getItem());
                cell2.putItem(tempItem);
            } else {
                for(MatchResult result: matchResultList){
                    //increment points
                    swapPoints += result.getPoints();
                    //set cell to empty
                    removeItemsFrom(result);
                }
            }
        }

        return swapPoints;
    }

    /**
     * removes all the items in the cell that generated a match
     * @param result
     */
    private void removeItemsFrom(MatchResult result) {
        int x = result.getPositionX();
        int y = result.getPositionY();
        int horizontalSize = result.getHorizontalSize();
        int verticalSize = result.getVerticalSize();

        for (int i = y; i<horizontalSize ;i++){
            level.getCells()[x][i].setEmpty(true);
        }

        for (int j = y; j<verticalSize ;j++){
            level.getCells()[j][y].setEmpty(true);
        }


    }

    /***
     * A swap is allowed only between horisontaly and verticaly adjacent cells
     * @return
     */
    private boolean isSwapAllowed(int cell1X,int cell1Y,int cell2X, int cell2Y){
        return (Math.pow(cell1X - cell2X,2) + Math.pow(cell1Y - cell2Y,2))==1;
    }

}
