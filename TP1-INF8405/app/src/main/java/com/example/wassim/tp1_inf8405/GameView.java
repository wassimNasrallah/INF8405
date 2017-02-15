package com.example.gamyot.spacejet;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by gamyot on 2017-02-14.
 */

public class GameView extends SurfaceView implements Runnable {
    //indicates if we are playing
    volatile boolean playing;
    //the game thread
    private Thread gameThread = null;

    private Player player;

    //Drawing objects
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;



    public GameView(Context context, int screenX, int screenY) {
        super(context);

        //initialize player
        player = new Player(context, screenX, screenY);

        //initialize drawing objects
        paint = new Paint();
        surfaceHolder = getHolder();

    }


    @Override
    public void run() {
        while(playing){
            update();
            draw();
            control();
        }

    }


    private void update() {
        player.update();
    }

    private void draw(){
        //verify if surface is valid
        if(surfaceHolder.getSurface().isValid()){
            //lock canvas
            canvas = surfaceHolder.lockCanvas();
            //draw backgroud
            canvas.drawColor(Color.BLACK);
            //draw images on canvas
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);
            //unlock canvas
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void control() {
        try{
            gameThread.sleep(17);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void pause(){
        //pausing the game loop
        playing = false;
        try {
            //stoping the thread
            gameThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void resume(){
        playing = true;
        gameThread= new Thread(this);
        gameThread.start();
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
            //when the user press the screen
            case MotionEvent.ACTION_UP:
                player.setBoosting();
                break;
            //when the user release the screen
            case MotionEvent.ACTION_DOWN:
                player.stopBoosting();
                break;
        }
        return true;
    }

}
