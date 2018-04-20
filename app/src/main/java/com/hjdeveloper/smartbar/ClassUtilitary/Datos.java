package com.hjdeveloper.smartbar.ClassUtilitary;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Developer on 04/04/2017.
 */

public class Datos {

    static ArrayList<String> arrayListMix;
    static ArrayList<String> arrayListMixKey;
    static ArrayList<String> arrayListMixValue;


    public static HashMap<String, String> myMap;
    static String[] mixesNames={"Mezcla1","Mezcla2","Mezcla3","Mezcla4","Mezcla5"};
    static String[] mixesComponet={"10,40,50,0","25,40,35,0","10,60,30,0","35,35,30,0","20,20,60,0"};

    public Datos(){
        arrayListMix=new ArrayList<>();
        arrayListMixKey=new ArrayList<>();
        arrayListMixValue=new ArrayList<>();
        myMap=new HashMap<>();
        llenarArrayListMix();
    }

    public void llenarArrayListMix(){
        for (int i=0;i<mixesNames.length;i++){
            this.arrayListMix.add(mixesNames[i]+","+mixesComponet[i]);
            this.arrayListMixKey.add(mixesNames[i]);
            this.arrayListMixValue.add(mixesComponet[i]);
            myMap.put(mixesNames[i],mixesComponet[i]);
        }
    }

    public ArrayList getArrayListKey(){
        return arrayListMixKey;
    }

    public ArrayList getArrayListValues(){
        return this.arrayListMixValue;
    }

    public HashMap getHasMapMix(){
        return this.myMap;
    }

    public void setArrayListMix(String Key, String Value){
        this.arrayListMix.add(Key+","+Value);
        this.arrayListMixKey.add(Key);
        this.arrayListMixValue.add(Value);
        myMap.put(Key,Value);
    }

    public void editArrayListMix(String Key, String Value, int position){
        this.arrayListMix.add(position,Key+","+Value);
        this.arrayListMixKey.add(position,Key);
        this.arrayListMixValue.add(position,Value);
        myMap.remove(Key);
        myMap.put(Key,Value);
    }


    public void removeArrayListMix(int position){
        this.arrayListMix.remove(position);
        this.arrayListMixKey.remove(position);
        this.arrayListMixValue.remove(position);
    }

    public void removeHasMap(String Key){
        myMap.remove(Key);
    }
}