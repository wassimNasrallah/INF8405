package com.example.wassim.tp1_inf8405;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import com.example.wassim.tp1_inf8405.GameView;
import com.example.wassim.tp1_inf8405.elements.Board;

public class GameActivity extends AppCompatActivity {
    //declaring game view
    private GameView gameView;

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

        //Initializing the game view
        gameView = new GameView(this,new Board(value),size);

        setContentView(gameView);
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
