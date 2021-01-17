package com.company.producer_consumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    static int x = 0;
    private final BlockingQueue<String>queue;
    public Producer(BlockingQueue<String> q) { queue = q; }
    public void run() {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            try {
                queue.put(importantInfo[i]);
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
}

