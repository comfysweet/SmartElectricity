package com.devices.domain;

public class Device {

    private String id;
    private String name;
    private Double averagePower;
    private String state;
    private String payment;

    public Device(String id, String name, Double averagePower, String state, String payment) {
        this.id = id;
        this.name = name;
        this.averagePower = averagePower;
        this.state = state;
        this.payment = payment;
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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
