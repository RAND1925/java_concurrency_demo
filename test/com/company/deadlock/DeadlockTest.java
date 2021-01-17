package com.company.deadlock;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class DeadlockTest {
    @Test
    public void testDeadlock() {
        // junit is not a daemon thread
        ExecutorService executor = Executors.newCachedThreadPool();

        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        executor.submit(() -> {
            while(true) {
                alphonse.bow(gaston);
            }
        });
        executor.submit(() -> {
            while(true) {
                gaston.bow(alphonse);
            }
        });
        try {
            boolean res = executor.awaitTermination(10, TimeUnit.SECONDS);
            if (!res) {
                System.out.println("deadlock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}