package com.redisstore.domain;

import java.io.Serializable;

import java.util.ArrayList;

public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    private String paymentPeriod;
    private String counterType;
    private ArrayList<String> lastValue;
    private ArrayList<String> currentValue;

    public Record() {
    }

    public Record(String paymentPeriod, String counterType, ArrayList<String> lastValue, ArrayList<String> currentValue) {
        this.paymentPeriod = paymentPeriod;
        this.counterType = counterType;
        this.lastValue = lastValue;
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "Record{" +
                "paymentPeriod='" + paymentPeriod + '\'' +
                ", counterType='" + counterType + '\'' +
                ", lastValue=" + lastValue +
                ", currentValue=" + currentValue +
                '}';
    }

    public String getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(String paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public String getCounterType() {
        return counterType;
    }

    public void setCounterType(String counterType) {
        this.counterType = counterType;
    }

    public ArrayList<String> getLastValue() {
        return lastValue;
    }

    public void setLastValue(ArrayList<String> lastValue) {
        this.lastValue = lastValue;
    }

    public ArrayList<String> getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(ArrayList<String> currentValue) {
        this.currentValue = currentValue;
    }
}