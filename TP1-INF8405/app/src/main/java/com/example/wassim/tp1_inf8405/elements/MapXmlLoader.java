package com.example.wassim.tp1_inf8405.elements;

import android.content.Context;
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

    private static Context context;

    public static void setContext(Context c){
        context = c;
    }
    public MapXmlLoader(){
    }
    public Level loadXml(int mapNumber) throws XmlPullParserException, IOException {
        int id=0;
        String lvlName = null;
        switch (mapNumber){
            case 1:
                id = R.xml.map1;
                lvlName = "Niveau 1";
                break;
            case 2:
                id = R.xml.map2;
                lvlName = "Niveau 2";
                break;
            case 3:
                id = R.xml.map3;
                lvlName = "Niveau 3";
                break;
            case 4:
                id = R.xml.map4;
                lvlName = "Niveau 4";
        }
        XmlResourceParser xmlLoader = context.getResources().getXml(id);

        int nbRow = 0;
        int nbColumns = 0;
        int nbMoves = 0;
        int ptsNeeded = 0;
        String[] rowData = null;
        int eventType = xmlLoader.getEventType();
        int rowIndex = 0;
        while(eventType != XmlPullParser.END_DOCUMENT){

            if(eventType == XmlPullParser.START_TAG){
                String tagName = xmlLoader.getName();
                if( tagName.equalsIgnoreCase("mapinfo")){
                    String data = xmlLoader.nextText();
                    String nbRowTxt = data.substring(0,data.indexOf("nbColumns")).replaceAll("nbRow","").replaceAll("=","").replaceAll("\"","").trim();
                    String nbColumnTxt = data.substring(data.indexOf("nbColumns"),data.indexOf("nbMove")).replaceAll("nbColumns","").replaceAll("=","").replaceAll("\"","").trim();
                    String nbMoveTxt = data.substring(data.indexOf("nbMove"),data.indexOf("ptsNeeded")).replaceAll("nbMove","").replaceAll("=","").replaceAll("\"","").trim();
                    String ptsNeededTxt = data.substring(data.indexOf("ptsNeeded")).replaceAll("ptsNeeded","").replaceAll("=","").replaceAll("\"","").trim();
                    nbRow = Integer.parseInt(nbRowTxt);
                    rowData = new String[nbRow];
                    nbColumns = Integer.parseInt(nbColumnTxt);
                    nbMoves = Integer.parseInt(nbMoveTxt);
                    ptsNeeded = Integer.parseInt(ptsNeededTxt);
                }else if(tagName.equalsIgnoreCase("row")){
                    rowData[rowIndex++] = xmlLoader.nextText();
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
        return new Level(lvlName,ptsNeeded,nbMoves,cells,nbColumns,nbRow);
    }
}
