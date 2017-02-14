package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public enum LevelEnum {
    LEVEL_1("level1"),
    LEVEL_2("level2"),
    LEVEL_3("level3"),
    LEVEL_4("level4");

    private String texturePath;

    LevelEnum(final String texturePath) {
        this.texturePath = texturePath;
    }

    public String getTexturePath() {
        return texturePath;
    }
}
