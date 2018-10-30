package com.diagram.repository;

import com.diagram.domain.Point;

import java.util.ArrayList;
import java.util.Map;

public interface DiagramRedisRepository {

    /**
     * Return all records
     */
    Map<Object, Object> findAllPoints();

    /**
     * Add key-value pair to Redis.
     */
    void add(Point point);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);

    /**
     * Delete a key-value pair in Redis.
     */
    void deleteAll();

    /**
     * find a record
     */
    Point findPoint(String id);

    /**
     * Add key-value pairs to Redis.
     */
    void add(ArrayList<Point> points);
}
