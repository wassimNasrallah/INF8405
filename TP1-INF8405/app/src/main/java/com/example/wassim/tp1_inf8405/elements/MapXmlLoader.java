package com.example.wassim.tp1_inf8405.elements;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;

import com.example.wassim.tp1_inf8405.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by Louis-Philippe on 2/15/2017.
 */

public class MapXmlLoader extends AppCompatActivity {

    public Cell[][] loadXml(int mapNumber) throws XmlPullParserException, IOException {
        int id=0;
        switch (mapNumber){
            case 1:
                id = R.xml.map1;
                break;
            case 2:
                id = R.xml.map2;
                break;
            case 3:
                id = R.xml.map3;
                break;
            case 4:
                id = R.xml.map4;
        }
        XmlResourceParser xmlLoader = getApplicationContext().getResources().getXml(id);

        int nbRow = 0;
        int nbColumns = 0;
        int nbMoves = 0;
        int ptsNeeded = 0;
        String[] rowData = null;

        int eventType = xmlLoader.getEventType();
        while(eventType != XmlPullParser.END_DOCUMENT){
            int rowIndex = 0;
            if(eventType == XmlPullParser.START_TAG){
                String tagName = xmlLoader.getName();
                if( tagName.equalsIgnoreCase("mapinfo")){
                    for(int i =0; i<xmlLoader.getAttributeCount();i++){
                        if(xmlLoader.getAttributeName(i).equalsIgnoreCase("nbrow")) {
                            nbRow = xmlLoader.getAttributeIntValue(i, 0);
                            rowData = new String[nbRow];
                        }else if(xmlLoader.getAttributeName(i).equalsIgnoreCase("nbcolumns"))
                            nbColumns = xmlLoader.getAttributeIntValue(i,0);
                        else if(xmlLoader.getAttributeName(i).equalsIgnoreCase("nbmove"))
                            nbMoves = xmlLoader.getAttributeIntValue(i,0);
                        else if(xmlLoader.getAttributeName(i).equalsIgnoreCase("ptsneeded"))
                            ptsNeeded = xmlLoader.getAttributeIntValue(i,0);
                    }
                }else if(tagName.equalsIgnoreCase("row")){
                    rowData[rowIndex++] = xmlLoader.getText();
                }
            }
            eventType = xmlLoader.nextToken();
        }

        Cell[][] cells = new Cell[nbRow][nbColumns];
        for(int i=0;i<nbRow;i++){
            int j = 0;
            for(String s : rowData[i].split(" ")){
                Cell c = new Cell(new Item(s));
                cells[i][j++] = c;
            }
        }
        return cells;
    }
}
