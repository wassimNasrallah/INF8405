package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class Board {
    //game attributes
    private Level level;
    private int actualScore;
    private int movesDone;
    private boolean playing;

    //utilitary attributes
    ItemFactory itemFactory;
    ItemHandler itemHandler;
    SwapController swapController;
    MatchFinder matchFinder;
    LevelFactory levelFactory;

    public Board(int lvl){

        levelFactory = new LevelFactory();
        itemFactory = new ItemFactory();
        itemHandler = new ItemHandler();
        swapController = new SwapController(this);
        //matchFinder = new MatchFinder();
        prepareLevel(lvl);
        matchFinder = null;
    }

    private void prepareLevel(int lvl){
        level = levelFactory.buildLevel(lvl);
        actualScore = 0;
        movesDone = 0;
    }

    public void gameLoop(){
        while(playing){

        }

    }

    public Level getLevel() {
        return level;
    }

    public void update(){

    }
}
