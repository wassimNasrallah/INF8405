package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class Board {
    //game

    private Level level;
    private int score;
    private int moves;

    //utilitary attributes
    ItemFactory itemFactory;
    ItemHandler itemHandler;
    SwapController swapController;
    MatchFinder matchFinder;
    LevelFactory levelFactory;

    public Board(Level level){
        this.level = level;
        prepareLevel();
        levelFactory = new LevelFactory();
        itemFactory = new ItemFactory();
        itemHandler = new ItemHandler();
        swapController = new SwapController(this);
        matchFinder = new MatchFinder();
    }

    private void prepareLevel(){
        level = levelFactory.buildLevel(level);
        score = 0;
        moves = 0;
    }


    public void update(){

    }
}
