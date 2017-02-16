package com.example.wassim.tp1_inf8405;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.wassim.tp1_inf8405.elements.Board;
import com.example.wassim.tp1_inf8405.elements.Cell;
import com.example.wassim.tp1_inf8405.elements.Item;
import com.example.wassim.tp1_inf8405.elements.ItemTypeEnum;

import java.util.HashMap;
import java.util.Map;

import static com.example.wassim.tp1_inf8405.elements.MapXmlLoader.context;

/**
 * Created by gamyot on 2017-02-14.
 */

public class GameView extends SurfaceView implements Runnable {
    //indicates if we are playing
    volatile boolean playing;
    //the game thread
    private Thread gameThread = null;

    //Drawing objects
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private Point screenSize;
    private int vector;
    private int decal;
    private int xStart;
    private int yStart;
    private Map<ItemTypeEnum,Bitmap> bitMapForType;

private Board board ;
    public GameView(Context context, Board board,Point size) {
        super(context);
        this.board = board;


        screenSize = size;
        System.out.println(board.getLevel().getAmountOfRows());
        int vectorH = (screenSize.y-20)/ board.getLevel().getAmountOfRows();
        int vectorW = (screenSize.x-20)/ board.getLevel().getAmountOfCollumns();

        vector = vectorH<vectorW?vectorH:vectorW;

        decal = (screenSize.y)-vector*(board.getLevel().getAmountOfRows()+1);

        bitMapForType = new HashMap<ItemTypeEnum, Bitmap>();
        bitMapForType.put(ItemTypeEnum.TYPE_BLUE,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.blue), vector, vector, false));
        bitMapForType.put(ItemTypeEnum.TYPE_GREEN,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.green), vector, vector, false));
        bitMapForType.put(ItemTypeEnum.TYPE_ORANGE,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.orange), vector, vector, false));
        bitMapForType.put(ItemTypeEnum.TYPE_PURPLE,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.purple), vector, vector, false));
        bitMapForType.put(ItemTypeEnum.TYPE_RED,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.red), vector, vector, false));
        bitMapForType.put(ItemTypeEnum.TYPE_YELLOW,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.yellow), vector, vector, false));

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
        ((GameActivity)context).update();
    }

    private void draw(){
        //verify if surface is valid
        if(surfaceHolder.getSurface().isValid()){
            //lock canvas
            canvas = surfaceHolder.lockCanvas();
            //draw backgroud
            canvas.drawColor(Color.WHITE);
            //draw images on canvas

            String moves = "Mouvement"+(board.getMovesDone()>1?"s":"")+" effectué"+(board.getMovesDone()>1?"s":"")+" : "+board.getMovesDone();
            String movesMax = "Mouvements maximum : "+board.getLevel().getMaxMoves();
            String actualPts = "Point"+(board.getActualScore()>1?"s":"")+" : "+board.getActualScore();
            String ptsMax = "Points requis : "+board.getLevel().getScoreGoal();
            paint.setTextSize(40);
            canvas.drawText(moves.toCharArray(),0,moves.length(),10,40,paint);
            canvas.drawText(movesMax.toCharArray(),0,movesMax.length(),10,100,paint);
            canvas.drawText(actualPts.toCharArray(),0,actualPts.length(),10,160,paint);
            canvas.drawText(ptsMax.toCharArray(),0,ptsMax.length(),10,220,paint);

            int posY = 0;
            for(Cell[] ce : board.getLevel().getCells()){
                int posX =0;
                for(Cell c : ce){
                    if(bitMapForType.containsKey(c.getItem().getType()))
                        canvas.drawBitmap(bitMapForType.get(c.getItem().getType()),(posX)*vector,posY*vector+ decal,paint);
                    posX++;
                }
                posY++;
            }
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

        int xIndex,yIndex;
        xIndex = Math.round(motionEvent.getX())/vector;
        yIndex = Math.round(motionEvent.getY()-decal)/vector;

        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
            //when the user press the screen
            case MotionEvent.ACTION_DOWN:
                xStart = xIndex;
                yStart = yIndex;
                System.out.println("ActionDown"+xIndex+"|"+yIndex);
                break;
            //when the user release the screen
            case MotionEvent.ACTION_UP:
                System.out.println("ActionUP"+xIndex+"|"+yIndex);
                board.getSwapController().swap(xStart,yStart,xIndex,yIndex);
                break;
        }
        return true;
    }

}
