package com.company;

import com.company.util.Util;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int integer = 0;
        for (int i= 0; i < 20; ++i) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("util " + new Random().nextInt());
                    // better performance
                    System.out.println("thrd " + ThreadLocalRandom.current().nextInt());
                }
            });
        }
    }
}
