package com.diagram.domain;

import java.io.Serializable;

public class Point  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String value;

    public Point(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public Point() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
