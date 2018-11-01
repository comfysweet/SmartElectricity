package com.diagram.domain;

import com.diagram.repository.DiagramRedisRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DiagramService {

    private ArrayList<Point> points;

    public DiagramRedisRepositoryImpl diagramRepository;

    public DiagramService(DiagramRedisRepositoryImpl diagramRepository) {
        this.diagramRepository = diagramRepository;
        createMock();
    }

    private void createMock() {
        points = new ArrayList<>();
        Double counter;

        for (Integer i = 1; i < 289; i++) {
            counter = ThreadLocalRandom.current().nextDouble(0.0, 3.5);
            points.add(new Point(i.toString(), counter.toString()));
        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }


    public ArrayList<DiagramEntry> getPointsForDay() {

        ArrayList<String> hours = new ArrayList<>();
        hours.add("00-02");
        hours.add("02-04");
        hours.add("04-06");
        hours.add("06-08");
        hours.add("08-10");
        hours.add("10-12");
        hours.add("12-14");
        hours.add("14-16");
        hours.add("16-18");
        hours.add("18-20");
        hours.add("20-22");
        hours.add("22-24");

        ArrayList<DiagramEntry> diagramEntries = new ArrayList<>();
       for (String hour:hours) {
           String row ="";
           for (int i = 0; i<24;i++) {
              row = row + "#"  + String.valueOf(ThreadLocalRandom.current().nextDouble(0.0, 3.5));
           }
           row = row.substring(1);
           diagramEntries.add(new DiagramEntry(hour,row));
        }
        return diagramEntries;

/*
        LinkedHashMap<String, LinkedHashMap> resultOfPoints = new LinkedHashMap<>();

        int sizeOfPoints = points.size();
        int sizeBegin = sizeOfPoints - 288;

        for (int i = 0; i < 12; i++) {
            Double averageValue = 0.0;
            ArrayList<String> pointsForHours = new ArrayList<>();
            for (int j = sizeBegin; j < sizeBegin + 24; j++) {
                double roundOff = Math.round(Double.valueOf(points.get(j).getValue()) * 100) / 100;
                pointsForHours.add(String.valueOf(roundOff));
                averageValue = averageValue + Double.valueOf(points.get(j).getValue());
            }

            averageValue = (double) Math.round(averageValue / 24);
            LinkedHashMap map = new LinkedHashMap();

            map.put(pointsForHours, averageValue);

            resultOfPoints.put(hours.get(i), map);

            sizeBegin = sizeBegin + 24;
        }

        return resultOfPoints;*/
    }

    public Point getPoint(String id) {
        return diagramRepository.findPoint(id);
    }
}
