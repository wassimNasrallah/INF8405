package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class Level {
    private String levelName;
    private Cell[][] cells;
    private int collumns;
    private int rows;
    private int scoreGoal;
    private int maxMoves;

    Level(final String levelName, final int score, final int moves, Cell[][] cells, int collumns, int rows) {
        this.levelName = levelName;
        scoreGoal = score;
        maxMoves = moves;
        this.cells = cells;
    }

    public int getAmountOfCollumns() {
        return collumns;
    }

    public int getAmountOfRows() {
        return rows;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getScoreGoal() {
        return scoreGoal;
    }

    public void setScoreGoal(int scoreGoal) {
        this.scoreGoal = scoreGoal;
    }
    public int getMaxMoves() {
        return maxMoves;
    }

    public void setMaxMoves(int maxMoves) {
        this.maxMoves = maxMoves;
    }


    public Cell[][] getCells() {
        return cells;
    }
}
