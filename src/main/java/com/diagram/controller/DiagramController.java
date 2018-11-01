package com.diagram.controller;

import com.diagram.domain.DiagramService;
import com.diagram.domain.Point;
import com.diagram.repository.DiagramRedisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/diagram")
public class DiagramController {
    private DiagramService diagramService;

    private DiagramRedisRepository diagramRedisRepository;

    public DiagramController(DiagramService diagramService, DiagramRedisRepository diagramRedisRepository) {
        this.diagramService = diagramService;
        this.diagramRedisRepository = diagramRedisRepository;
    }

    @PostMapping(value = "/mockDiagram")
    public @ResponseBody
    ResponseEntity<String> getRecords() {
        diagramRedisRepository.add(diagramService.getPoints());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping
    public String Diagram() {
        return "Diagram";
    }

    @RequestMapping("/keys")
    public @ResponseBody
    Map<Object, Object> keys() {
        return diagramRedisRepository.findAllPoints();
    }

    @RequestMapping("/values")
    public @ResponseBody
    Map<String, String> findAll() {
        Map<Object, Object> aa = diagramRedisRepository.findAllPoints();
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : aa.entrySet()) {
            String key = (String) entry.getKey();
            map.put(key, aa.get(key).toString());
        }
        return map;
    }

    @PostMapping
    public ResponseEntity<String> add(
            @RequestParam String id,
            @RequestParam String value
    ) {

        Point point = new Point(id, value);

        diagramRedisRepository.add(point);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<String> delete(@PathVariable("key") String key) {
        diagramRedisRepository.delete(key);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/pointsForDay")
    public @ResponseBody
    LinkedHashMap<String, LinkedHashMap> getPointsForDay() {
        LinkedHashMap<String, LinkedHashMap> resultPoints = diagramService.getPointsForDay();
        return resultPoints;
    }
}
