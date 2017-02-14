package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class Board {
    //game
    private Cell [][] cells;
    private LevelEnum level;

    //utilitary attributes
    ItemFactory itemFactory;
    ItemHandler itemHandler;
    SwapController swapController;
    MatchFinder matchFinder;
    LevelFactory levelFactory;

    public Board(LevelEnum level){
        this.level = level;

        levelFactory = new LevelFactory();

        itemFactory = new ItemFactory();
        itemHandler = new ItemHandler();
        swapController = new SwapController(this);
        matchFinder = new MatchFinder();


    }

    /**
     * Set the cell acording to a level
     * @param newCells
     */
    private void prepareLevel(){
        cells = levelFactory.buildLevel(level);
    }

    public void reset(LevelEnum level){

    }

    public void update(){

    }
}
