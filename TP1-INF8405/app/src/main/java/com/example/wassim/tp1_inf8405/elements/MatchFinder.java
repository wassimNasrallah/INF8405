package com.example.wassim.tp1_inf8405.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gamyot on 2017-02-13.
 */

public class MatchFinder {
    private Cell[][] boardCells;
    private Level level;

    public MatchFinder(Level level) {

        this.boardCells = level.getCells();
        this.level = level;
    }


    /**
     * Look for all the matches
     * @return
     */
    public List<MatchResult> findMatches(){
        List<MatchResult> matchResultList = new ArrayList<>();
        for (int i = 0 ; i < level.getAmountOfRows(); i++){
            for (int j = 0; j < level.getAmountOfCollumns(); j++){
                MatchResult matchResult = findCellMatches(i, j);
                if (matchResult.getPoints() > 0 ){
                    matchResultList.add(matchResult);

                }
            }
        }
        return matchResultList;
    }



    /**
     * Finds all the matching cell surrounding the current
     * cell looking right and down for matches
     *
     * @param x horizontal position of the cell
     * @param y vertical x position of the cell
     * @return a MatchResult object containing all the
     * information about adjacent matches
     */
    public MatchResult findCellMatches(int x, int y){
        MatchResult result = new MatchResult(boardCells[x][y],x,y);
        //horisontal check
        int horisontalCount = countRightMatches(x, y);
        if (horisontalCount>=3){
            result.setHorizontalSize(horisontalCount);
            result.addPoints(calculatePoints(horisontalCount));
        }
        //vertical check
        int verticalCount = countDownMatches(x, y);
        if (verticalCount>3){
            result.setVerticalSize(verticalCount);
            result.addPoints(calculatePoints(verticalCount));
        }
        return result;

    }

    private int countRightMatches(int x, int y) {
        int result = 1;
        Cell actualCell = boardCells[x][y];
        int i = y;
        boolean doContinue = true;
        boolean foundDifferent = false;
        while(doContinue){
            i++;
            if(i < level.getAmountOfCollumns() && !foundDifferent){
                if (boardCells[x][i].getItem().getType() == actualCell.getItem().getType()
                        && boardCells[x][i].getItem().getType() != ItemTypeEnum.TYPE_NONE){
                    result++;
                }else{
                    foundDifferent = true;
                }
            }else{
                doContinue = false;
            }
        }
        return result;
    }

    private int countDownMatches(int x, int y) {
        int result = 0;
        Cell actualCell = boardCells[x][y];
        int i = x;
        boolean doContinue = true;
        boolean foundDifferent = false;
        while(doContinue){
            i++;
            if(i < level.getAmountOfRows() && !foundDifferent){
                Cell comparedCell = boardCells[i][y];
                if (comparedCell.getItem().getType() == actualCell.getItem().getType()
                        && boardCells[x][i].getItem().getType() != ItemTypeEnum.TYPE_NONE){
                    result++;
                }else{
                    foundDifferent = true;
                }
            }else{
                doContinue = false;
            }
        }
        return result;
    }


    private int calculatePoints(int matches){
        return (matches-2)*100;
    }
}
