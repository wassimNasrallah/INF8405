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
                Intent myIntent = new Intent(getBaseContext(), GameActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", 1);
                myIntent.putExtras(b);
                startActivity(myIntent);
            }
        });

        level2 = (Button) findViewById(R.id.buttonLevel2);
        level2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), GameActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", 2);
                myIntent.putExtras(b);
                startActivity(myIntent);
            }
        });

        level3 = (Button) findViewById(R.id.buttonLevel3);
        level3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), GameActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", 3);
                myIntent.putExtras(b);
                startActivity(myIntent);
            }
        });

        level4 = (Button) findViewById(R.id.buttonLevel4);
        level4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), GameActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", 4);
                myIntent.putExtras(b);
                startActivity(myIntent);
            }
        });

    }

}
