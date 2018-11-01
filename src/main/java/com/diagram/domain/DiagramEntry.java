package com.diagram.domain;

public class DiagramEntry {
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    private String hour;

    public String getPointsRow() {
        return pointsRow;
    }

    public void setPointsRow(String pointsRow) {
        this.pointsRow = pointsRow;
    }

    private String pointsRow;

    public DiagramEntry(String hour, String pointsRow) {
        this.hour = hour;
        this.pointsRow = pointsRow;
    }
}
