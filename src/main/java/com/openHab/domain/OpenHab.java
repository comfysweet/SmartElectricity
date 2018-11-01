package com.openHab.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenHab implements Serializable {


    private static final long serialVersionUID = 1L;

    private String id;
    private String nameOfDevice;
    private String state;
    private String valueOfPower;
    private SimpleDateFormat dateTime;

  //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public OpenHab(String nameOfDevice, String state, String valueOfPower, SimpleDateFormat dateTime) {
        this.nameOfDevice = nameOfDevice;
        this.state = state;
        this.valueOfPower = valueOfPower;
        this.dateTime = dateTime;
    }

    public OpenHab() {
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

    public SimpleDateFormat getDateTime() {
        return dateTime;
    }

    public void setDateTime(SimpleDateFormat dateTime) {
        this.dateTime = dateTime;
    }
}
