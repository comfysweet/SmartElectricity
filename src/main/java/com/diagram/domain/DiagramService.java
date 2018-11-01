package com.diagram.domain;

import com.diagram.repository.DiagramRedisRepositoryImpl;
import com.openHab.domain.OpenHABService;
import com.openHab.domain.OpenHab;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DiagramService {

    private OpenHABService openHABService;

    private ArrayList<Point> points;

    public DiagramRedisRepositoryImpl diagramRepository;

    public DiagramService(DiagramRedisRepositoryImpl diagramRepository, OpenHABService openHABService) {
        this.diagramRepository = diagramRepository;
        this.openHABService = openHABService;
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

//        ArrayList<OpenHab> openHabs = openHABService.getOpenHabs();
//
//        for(OpenHab openHab: openHabs){
//            Date dateFormat=  openHab.getDateTime().get2DigitYearStart();
//            System.out.println(dateFormat.toString());
//        }
        Integer valueOfHours = 0;
        ArrayList<DiagramEntry> diagramEntries = new ArrayList<>();
        for (String hour : hours) {

            String row = "";
            for (int i = 0; i < 24; i++) {
                Double initValue = 0.0;
                if (valueOfHours < 1) {
                    row = row + "#" + String.valueOf(initValue);
                }
                if (valueOfHours >= 1 && valueOfHours <= 6) {
                    row = row + "#" + String.valueOf(ThreadLocalRandom.current().nextDouble(3.0, 3.5));
                }
                if (valueOfHours > 6) {
                    row = row + "#" + String.valueOf(ThreadLocalRandom.current().nextDouble(0.0, 3.5));
                }
                //row = row + "#"  + String.valueOf(ThreadLocalRandom.current().nextDouble(0.0, 3.5));
            }
            row = row.substring(1);
            diagramEntries.add(new DiagramEntry(hour, row));
            valueOfHours++;
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
