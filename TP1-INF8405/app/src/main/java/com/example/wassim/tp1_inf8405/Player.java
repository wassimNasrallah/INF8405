package com.example.gamyot.spacejet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by gamyot on 2017-02-15.
 */

public class Player {
    //image that represents the player
    private Bitmap bitmap;
    //position
    private int x;
    private int y;
    //speed
    private int speed;
    //accelerating
    private boolean boosting;
    private final int GRAVITY = -10;
    private final int MAX_SPEED = 20;
    private final int MIN_SPEED = 1;
    //establishing boundaries
    private int minY;
    protected int maxY;

    public Player(Context context, int screenX, int screenY) {
        //set initial position
        x = 75;
        y = 50;
        speed = 1;
        boosting = false;
        //gather the image from drawable folder
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.player);

        //calculating maxY
        maxY = screenY - bitmap.getHeight();
        minY = 0;

    }

    //update player
    public void update(){
        //boost control
        if(boosting){
            speed+=2;
        }else{
            speed-=5;
        }
        //top speed check
        if(speed > MAX_SPEED){
            speed = MAX_SPEED;
        }else if(speed < MIN_SPEED){
            speed = MIN_SPEED;
        }

        //apply gravity
        y -= speed + GRAVITY;

        //check screen boundaries
        if (x > maxY){
            x = maxY;
        }else if(x < minY){
            x = minY;
        }

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void stopBoosting() {
        boosting = false;
    }

    public void setBoosting() {
        boosting = true;
    }
}
