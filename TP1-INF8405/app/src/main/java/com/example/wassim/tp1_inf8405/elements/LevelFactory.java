package com.example.wassim.tp1_inf8405.elements;

/**
 * Created by gamyot on 2017-02-14.
 */

public class LevelFactory {

    public Level buildLevel(int levelId){
        try{
            return new MapXmlLoader().loadXml(levelId);
        }
        catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
