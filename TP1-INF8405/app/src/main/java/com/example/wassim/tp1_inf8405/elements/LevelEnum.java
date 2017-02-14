package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public enum LevelEnum {
    LEVEL_1("level1"),
    LEVEL_2("level2"),
    LEVEL_3("level3"),
    LEVEL_4("level4");

    private String levelName;

    LevelEnum(final String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }

    public boolean isEqual(LevelEnum level) {
        return this.getLevelName().equals(level.getLevelName());
    }
}
