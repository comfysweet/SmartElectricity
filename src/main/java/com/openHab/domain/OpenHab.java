package com.openHab.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class OpenHab implements Serializable {


    private static final long serialVersionUID = 1L;

    private String id;
    private String nameOfDevice;
    private String state;
    private String valueOfPower;
    private LocalDateTime dateTime;

    public OpenHab(String id, String nameOfDevice, String state, String valueOfPower, LocalDateTime dateTime) {
        this.id = id;
        this.nameOfDevice = nameOfDevice;
        this.state = state;
        this.valueOfPower = valueOfPower;
        this.dateTime = dateTime;
    }

    public String getNameOfDevice() {
        return nameOfDevice;
    }

    public void setNameOfDevice(String nameOfDevice) {
        this.nameOfDevice = nameOfDevice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getValueOfPower() {
        return valueOfPower;
    }

    public void setValueOfPower(String valueOfPower) {
        this.valueOfPower = valueOfPower;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
