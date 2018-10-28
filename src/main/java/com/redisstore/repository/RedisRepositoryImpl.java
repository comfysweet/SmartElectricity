package com.redisstore.repository;

import com.redisstore.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Record";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Record record) {
        hashOperations.put(KEY, record.getId(), record);
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    public Record findRecord(final String id) {
        return (Record) hashOperations.get(KEY, id);
    }

    public void add(final ArrayList<Record> records) {
        for (Record record : records) {
            add(record);
        }
    }

    public Map<Object, Object> findAllRecords() {
        return hashOperations.entries(KEY);
    }
}