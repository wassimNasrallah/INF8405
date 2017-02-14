package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class LevelFactory {

    public Level buildLevel(Level levelEnum){
        //TODO::call parser and fill the cells with the imported items
        String levelName = null;
        int score= 0;
        int moves = 0;
        Cell[][] boardCells = null;

        return new Level(levelName,score,moves,boardCells);

    }
}
