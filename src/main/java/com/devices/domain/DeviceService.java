package com.devices.domain;

import com.openHab.domain.OpenHabService;
import com.openHab.domain.OpenHab;
import com.redisstore.domain.RecordService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DeviceService {

    private OpenHabService openHabService;

    public DeviceService(OpenHabService openHabService) {
        this.openHabService = openHabService;
        createMock();
    }

    private ArrayList<Device> devices;

    public void createMock() {
        ArrayList<OpenHab> openHabs = openHabService.getOpenHabs();

        devices = new ArrayList<>();

        ArrayList<String> nameOfDevices = new ArrayList<>();
        nameOfDevices.add("Лампочка");

        Double averagePower = 0.0;

        for (OpenHab openHab : openHabs) {
            averagePower = averagePower + Double.valueOf(openHab.getValueOfPower());
        }

        averagePower = averagePower / openHabs.size();
        String payment = String.valueOf(Math.round(averagePower * 4.04));

        for (Integer i = 0; i < nameOfDevices.size(); i++) {
            devices.add(new Device(String.valueOf(i + 1), nameOfDevices.get(0), averagePower, openHabs.get(openHabs.size() - 1).getState(), payment));
        }
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

}
