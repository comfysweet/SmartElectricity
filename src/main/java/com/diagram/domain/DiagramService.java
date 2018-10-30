package com.diagram.domain;

import com.diagram.repository.DiagramRedisRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        Integer counter = 1;

        for (Integer i = 1; i < 21; i++) {
            points.add(new Point(i.toString(), counter.toString()));
            counter = counter + ThreadLocalRandom.current().nextInt(0, 50);
        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Point getPoint(String id) {
        return diagramRepository.findPoint(id);
    }
}
