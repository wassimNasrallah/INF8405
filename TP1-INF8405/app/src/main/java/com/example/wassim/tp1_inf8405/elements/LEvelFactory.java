package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class LevelFactory {

    public Cell[][] buildLevel(LevelEnum levelEnum){
        if (levelEnum.equals(LevelEnum.LEVEL_1)){
            return buildLevel1();
        }
        if (levelEnum.equals(LevelEnum.LEVEL_2.getLevelName())){
            return buildLevel2();
        }
        if (levelEnum.equals(LevelEnum.LEVEL_3.getLevelName())){
            return buildLevel3();
        }
        if (levelEnum.equals(LevelEnum.LEVEL_4.getLevelName())){
            return buildLevel4();
        }

        return null;//should not reach this...
    }


    private Cell[][] buildLevel1() {
        Cell[][] boardCells = new Cell[5][8];
        //
        return boardCells;

    }

    private Cell[][] buildLevel2() {
        Cell[][] boardCells = new Cell[6][8];

        return boardCells;
    }

    private Cell[][] buildLevel3() {
        Cell[][] boardCells = new Cell[7][7];

        return boardCells;
    }

    private Cell[][] buildLevel4() {
        Cell[][] boardCells = new Cell[8][7];

        return boardCells;
    }

}
