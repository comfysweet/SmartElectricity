package com.redisstore.queue;

public interface MessagePublisher {

    void publish(final String message);
}
