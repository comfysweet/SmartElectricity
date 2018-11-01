package com.openHab.domain;


import java.util.ArrayList;

public class OpenHABService {

    private ArrayList<OpenHab> openHabs;


    public OpenHABService() {
        openHabs = new ArrayList<>();
        for(int i=0; i< 288;i ++) {
            //openHabs.add(new OpenHab(i, "Холодильник", "",12.5, "Включен"));
        }
    }

    public ArrayList<OpenHab> getDevices() {
        return openHabs;
    }
}
