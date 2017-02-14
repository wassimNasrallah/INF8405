package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class Level {
    private String levelName;
    private int scoreGoal;
    private int maxMoves;

    Level(final String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }

    public boolean isEqual(Level level) {
        return this.getLevelName().equals(level.getLevelName());
    }
}
