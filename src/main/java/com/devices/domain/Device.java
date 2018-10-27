package com.devices.domain;

public class Device {

    private Integer id;
    private String name;
    private Double averagePower;
    private String state;

    public Device(Integer id, String name, Double averagePower, String state) {
        this.id = id;
        this.name = name;
        this.averagePower = averagePower;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAveragePower() {
        return averagePower;
    }

    public void setAveragePower(Double averagePower) {
        this.averagePower = averagePower;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
