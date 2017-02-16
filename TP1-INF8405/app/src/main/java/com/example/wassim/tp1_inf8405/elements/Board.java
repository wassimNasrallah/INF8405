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
    private int currentLvl;

    //utilitary attributes
    ItemFactory itemFactory;
    ItemHandler itemHandler;
    SwapController swapController;
    MatchFinder matchFinder;
    LevelFactory levelFactory;

    public Board(int lvl){

        this.currentLvl = lvl;
        levelFactory = new LevelFactory();
        itemFactory = new ItemFactory();

        prepareLevel(lvl);
        itemHandler = new ItemHandler(level);
        swapController = new SwapController(level);
    }

    private void prepareLevel(int lvl){
        level = levelFactory.buildLevel(lvl);
        System.out.println("level rows:"+level.getAmountOfRows());
        actualScore = 0;
        movesDone = 0;
    }

    public void gameLoop(){
        while(playing){

        }

    }

    public int getCurrentLvl(){return currentLvl;}
    public int getActualScore(){return actualScore;}
    public int getMovesDone(){return  movesDone;}
    public SwapController getSwapController(){return swapController;}
    public Level getLevel() {
        return level;
    }

    public void update(){

    }
}
