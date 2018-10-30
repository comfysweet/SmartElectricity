package com.diagram.repository;

import com.diagram.domain.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class DiagramRedisRepositoryImpl implements DiagramRedisRepository {
    private static final String KEY = "Point";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public DiagramRedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Point point) {
        hashOperations.put(KEY, point.getId(), point);
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public void deleteAll() {
        hashOperations.delete(KEY);
    }

    public Point findPoint(final String id) {
        return (Point) hashOperations.get(KEY, id);
    }

    public void add(final ArrayList<Point> points) {
        for (Point point : points) {
            add(point);
        }
    }

    public Map<Object, Object> findAllPoints() {
        return hashOperations.entries(KEY);
    }
}
