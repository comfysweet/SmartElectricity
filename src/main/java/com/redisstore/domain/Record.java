package com.redisstore.domain;

import java.io.Serializable;

public class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String year;
    private String month;
    private String kindCounter;
    private String lastValue;
    private String currentValue;

    public Record(String id, String year, String month, String kindCounter, String lastValue, String currentValue) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.kindCounter = kindCounter;
        this.lastValue = lastValue;
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", kindCounter='" + kindCounter + '\'' +
                ", lastValue='" + lastValue + '\'' +
                ", currentValue='" + currentValue + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getKindCounter() {
        return kindCounter;
    }

    public void setKindCounter(String kindCounter) {
        this.kindCounter = kindCounter;
    }

    public String getLastValue() {
        return lastValue;
    }

    public void setLastValue(String lastValue) {
        this.lastValue = lastValue;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }
}