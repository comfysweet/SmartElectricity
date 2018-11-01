package com.openHab.domain;


import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class OpenHABService {

    private ArrayList<OpenHab> openHabs;

    public OpenHABService() {
        openHabs = new ArrayList<>();
        ArrayList<String> state = new ArrayList<>();
        state.add("вкл");
        state.add("выкл");
        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        ArrayList<Integer> valueOfPower = new ArrayList<>();
        valueOfPower.add(0);
        valueOfPower.add(2);
        valueOfPower.add(1);

        String dateInit = "2018-01-02 00:00";
        int minute = 0;

        ArrayList<String> devices = new ArrayList<>();
        devices.add("Лампочка");

        for (int i = 0; i < 288; i++) {
            int power;
            int getState = ThreadLocalRandom.current().nextInt(0, 1);

            if (state.get(getState).equals("выкл")) {
                power = 0;
            } else
                power = ThreadLocalRandom.current().nextInt(2, 3);

            String inputModified = dateInit.replace(" ", "T");

            LocalDateTime ldt = LocalDateTime.parse(inputModified);
            LocalDateTime ldtLater = ldt.plusMinutes(minute);

            openHabs.add(new OpenHab(String.valueOf(i), devices.get(0), state.get(getState), String.valueOf(valueOfPower.get(power)), ldtLater));
            minute = minute + 5;
        }
    }

    public ArrayList<OpenHab> getOpenHabs() {
        return openHabs;
    }
}
