package com.company.producer_consumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> q) {
        queue = q;
    }

    public void run() {
        Random random = new Random();
        while (true){
            try {
                String message = queue.take();
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
}
