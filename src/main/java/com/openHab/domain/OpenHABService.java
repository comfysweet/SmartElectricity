package com.openHab.domain;


import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class OpenHabService {

    private ArrayList<OpenHab> openHabs;

    public OpenHabService() {
        openHabs = new ArrayList<>();
        ArrayList<String> state = new ArrayList<>();
        state.add("вкл");
        state.add("выкл");
        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        ArrayList<Integer> valueOfPower = new ArrayList<>();
        valueOfPower.add(0);
        valueOfPower.add(2);
        valueOfPower.add(1);

        ArrayList<String> devices = new ArrayList<>();
        devices.add("Лампочка");

        for (int i = 0; i < 288; i++) {
            int getState = ThreadLocalRandom.current().nextInt(0, 1);
            int power = ThreadLocalRandom.current().nextInt(0, 2);
//            int device = ThreadLocalRandom.current().nextInt(0, 0);

            openHabs.add(new OpenHab(String.valueOf(i), devices.get(0), state.get(getState), String.valueOf(valueOfPower.get(power)), dateTime));
        }
        System.out.println("hello");
    }

    public ArrayList<OpenHab> getOpenHabs() {
        return openHabs;
    }
}
