package com.example.wassim.tp1_inf8405;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Wassim on 09/02/2017.
 */

public class LevelSelect extends AppCompatActivity {


    private Button level1;
    private Button level2;
    private Button level3;
    private Button level4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_select);


        butListener();
    }


    public void butListener () {

        level1 = (Button) findViewById(R.id.buttonLevel1);
        level1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Level_1.class);
                startActivity(myIntent);
            }
        });

        level2 = (Button) findViewById(R.id.buttonLevel2);
        level2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Level_2.class);
                startActivity(myIntent);
            }
        });

        level3 = (Button) findViewById(R.id.buttonLevel3);
        level3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Level_3.class);
                startActivity(myIntent);
            }
        });

        level4 = (Button) findViewById(R.id.buttonLevel4);
        level4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Level_4.class);
                startActivity(myIntent);
            }
        });

    }

}
