package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-13.
 */

public enum ItemTypeEnum {
    TYPE_BLUE("blue"),
    TYPE_GREEN("green"),
    TYPE_PURPLE("purple"),
    TYPE_RED("red"),
    TYPE_WHITE("orange"),
    TYPE_YELLOW("yellow"),
    TYPE_NONE("");

    private String texturePath;

    ItemTypeEnum(final String texturePath) {
        this.texturePath = texturePath;
    }

    public String getTexturePath() {
        return texturePath;
    }
}
