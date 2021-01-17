package com.company.deadlock;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LockTest {

    static class BowLoop implements Runnable {
        private Friend bower;
        private Friend bowee;

        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        public void run() {
            Random random = new Random();
            for (;;) {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {}
                bowee.bow(bower);
            }
        }
    }
    @Test
    void testLock() {
        ExecutorService executor = Executors.newCachedThreadPool();

        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        executor.submit(new BowLoop(alphonse, gaston));
        executor.submit(new BowLoop(gaston, alphonse));
        try {
            boolean res = executor.awaitTermination(100, TimeUnit.SECONDS);
            if (!res) {
                System.out.println("deadlock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
