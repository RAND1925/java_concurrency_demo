package com.company;

import com.company.util.Util;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static final int times = 20;




    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i= 0; i < 20; ++i) {
            pool.execute(()->{
                // after java1.7
                System.out.println("util " + new Random().nextInt());
                // better performance
                System.out.println("thrd " + ThreadLocalRandom.current().nextInt());
            });
        }
    }
}
