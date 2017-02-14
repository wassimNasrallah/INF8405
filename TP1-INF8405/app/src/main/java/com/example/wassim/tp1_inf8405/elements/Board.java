package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public class Board {
    Cell [][] cells;
    ItemFactory itemFactory;
    ItemHandler itemHandler;
    SwapController swapController;
    MatchFinder matchFinder;

    public Board(int sizeX, int sizeY){
        cells = new Cell[sizeX][sizeY];
        itemFactory = new ItemFactory();
        itemHandler = new ItemHandler();
        swapController = new SwapController(this);
        matchFinder = new MatchFinder();


    }

    public void prepare(LevelEnum level){

    }

    public void reset(LevelEnum level){

    }

    public void update(){

    }
}
