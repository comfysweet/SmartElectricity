package com.openHab.repository;

import com.diagram.domain.Point;
import com.openHab.domain.OpenHab;

import java.util.ArrayList;
import java.util.Map;

public interface OpenHabRedisRepository {

    /**
     * Return all records
     */
    Map<Object, Object> findAllOpenHab();

    /**
     * Add key-value pair to Redis.
     */
    void add(OpenHab openHab);

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
    Point findOpenHab(String id);

    /**
     * Add key-value pairs to Redis.
     */
    void add(ArrayList<OpenHab> openHabs);
}
