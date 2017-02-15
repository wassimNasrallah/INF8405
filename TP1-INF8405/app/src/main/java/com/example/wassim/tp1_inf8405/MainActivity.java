package com.example.wassim.tp1_inf8405;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wassim.tp1_inf8405.elements.Board;
import com.example.wassim.tp1_inf8405.elements.MapXmlLoader;

public class MainActivity extends Activity {

    private Button rules;
    private Button start;
    private Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapXmlLoader.setContext(getApplicationContext());
        setContentView(R.layout.welcome_screen);
        butListener();
    }

    public void butListener () {

        rules = (Button) findViewById(R.id.buttonRules);
        rules.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), RulesClass.class);
                startActivity(myIntent);
            }
        });

        start = (Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), LevelSelect.class);
                startActivity(myIntent);
            }
        });

        quit = (Button) findViewById(R.id.buttonQuit);
        quit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}
