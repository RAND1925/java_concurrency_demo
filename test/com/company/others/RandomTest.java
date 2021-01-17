package com.company.others;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class RandomTest {
    @Test
    public void testRandom() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int integer = 0;
        for (int i= 0; i < 20; ++i) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("util\t" + new Random().nextInt());
                    // better performance
                    System.out.println("thread\t" + ThreadLocalRandom.current().nextInt());
                }
            });
        }
    }
}