package com.redisstore.repository;

import com.redisstore.domain.Record;

import java.util.ArrayList;
import java.util.Map;

public interface RecordRedisRepository {

    /**
     * Return all records
     */
    Map<Object, Object> findAllRecords();

    /**
     * Add key-value pair to Redis.
     */
    void add(Record record);

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
    Record findRecord(String id);

    /**
     * Add key-value pairs to Redis.
     */
    void add(ArrayList<Record> records);
}
