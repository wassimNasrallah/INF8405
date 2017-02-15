package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class MatchResult {
    private Cell matchingCell;
    private int positionX, positionY;
    private int horizontalSize, verticalSize;
    private int points;

    public MatchResult(Cell matchingCell, int positionX, int positionY) {
        this.matchingCell = matchingCell;
        this.positionX = positionX;
        this.positionY = positionY;
        this.horizontalSize = 0;
        this.verticalSize = 0;
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void addPoints(int points) {
        this.points += points;
    }

    public Cell getMatchingCell() {
        return matchingCell;
    }

    public void setMatchingCell(Cell matchingCell) {
        this.matchingCell = matchingCell;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public void setHorizontalSize(int horizontalSize) {
        this.horizontalSize = horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public void setVerticalSize(int verticalSize) {
        this.verticalSize = verticalSize;
    }



}
