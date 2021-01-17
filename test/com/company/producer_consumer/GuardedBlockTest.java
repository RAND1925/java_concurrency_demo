package com.company.producer_consumer;

import com.company.producer_consumer.guarded.Drop;
import com.company.producer_consumer.guarded.Producer;
import com.company.producer_consumer.guarded.Consumer;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class GuardedBlockTest {
    @Test
    void testGuardedBlock() {
        Drop drop = new Drop();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(new Producer(drop));
        executor.submit(new Consumer(drop));
        try {
            boolean res = executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}