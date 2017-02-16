package com.example.wassim.tp1_inf8405;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.wassim.tp1_inf8405.GameView;
import com.example.wassim.tp1_inf8405.elements.Board;

public class GameActivity extends AppCompatActivity {
    //declaring game view
    private GameView gameView;
    private Board board;
    private int currentLvl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        Bundle b = getIntent().getExtras();
        int value = -1;
        if(b != null)
            value = b.getInt("key");

        board = new Board(value);
        //Initializing the game view
        gameView = new GameView(this,board,size);

        setContentView(gameView);
    }

    public void restart(){
        gameView.pause();
        Intent myIntent = new Intent(getBaseContext(), GameActivity.class);
        Bundle b = new Bundle();
        b.putInt("key", board.getCurrentLvl());
        myIntent.putExtras(b);
        startActivity(myIntent);
    }

    public void update(){
        if(board.getLevel().getScoreGoal()<=board.getActualScore()){
            gameView.pause();
            if(board.getCurrentLvl()<4) {
                board = new Board(board.getCurrentLvl() + 1);
                Intent myIntent = new Intent(getBaseContext(), GameActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", board.getCurrentLvl()+1);
                myIntent.putExtras(b);
                startActivity(myIntent);
            }else{
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(myIntent);
            }
        }else if(board.getLevel().getMaxMoves()<board.getMovesDone()){
            gameView.pause();
            Intent myIntent = new Intent(getBaseContext(), GameActivity.class);
            Bundle b = new Bundle();
            b.putInt("key", board.getCurrentLvl());
            myIntent.putExtras(b);
            startActivity(myIntent);
        }
    }

    protected void onPause(){
        super.onPause();
        gameView.pause();
    }

    protected void onResume(){
        super.onResume();
        gameView.resume();
    }
}
