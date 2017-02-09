package com.example.wassim.tp1_inf8405;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);


        Button quit = (Button) findViewById(R.id.buttonQuit);
        quit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.exit(0);
            }
        });

        Button rules = (Button) findViewById(R.id.buttonRules);
        rules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RulesClass.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button start = (Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LevelSelect.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}
