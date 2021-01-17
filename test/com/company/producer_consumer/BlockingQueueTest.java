package com.company.producer_consumer;

import com.company.producer_consumer.blockingqueue.Consumer;
import com.company.producer_consumer.blockingqueue.Producer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

class BlockingQueueTest {
    @Test
    void testBlockingQueue() {
        ExecutorService executor = Executors.newCachedThreadPool();
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);
        executor.submit(new Producer(queue));
        executor.submit(new Consumer(queue));
        try {
            boolean res = executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}