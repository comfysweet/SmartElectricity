package com.devices.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DeviceService {

    private ArrayList<Device> devices;


    public DeviceService() {
        devices = new ArrayList<>();
        devices.add(new Device(1, "Холодильник", 12.5, "Включен"));
        devices.add(new Device(2, "Стиральная машина", 20.0, "Включен"));
        devices.add(new Device(3, "Микроволновая печь", 10.5, "Включен"));
        devices.add(new Device(4, "Светильник", 5.0, "Выключен"));
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

}
