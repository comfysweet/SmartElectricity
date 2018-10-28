package com.redisstore.repository;

import com.redisstore.domain.Record;

import java.util.ArrayList;
import java.util.Map;

public interface RedisRepository {

    /**
     * Return all movies
     */
    Map<Object, Object> findAllMovies();

    /**
     * Add key-value pair to Redis.
     */
    void add(Record record);

    /**
     * Delete a key-value pair in Redis.
     */
    void delete(String id);

    /**
     * find a movie
     */
    Record findMovie(String id);

    /**
     * Add key-value pairs to Redis.
     */
    void add(ArrayList<Record> records);
}
