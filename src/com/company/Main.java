package com.company;

import com.company.util.Util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int times = 10;

    private static void runNonConcurrency() {
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);
            new Task(si).run();
        }
    }

    public static void runThread() throws InterruptedException {
        Thread[] threads = new Thread[times];
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);
            Thread thread = new Thread(new Task(si), "thread"+ si);
            threads[i] = thread;
            thread.start();
            // thread.join(); // not like this caz it may
        }
        for (Thread thread: threads) {
            thread.join();
        }
    }

    public static void runExecutor() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);
            pool.execute(new Task((si)));
        }
        pool.shutdown();

        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
        }

    }
    public static void main(String[] args) throws InterruptedException {
        long begin =  Util.log("begin", "MAIN");
        //runNonConcurrency();
        long end = Util.log("end", "MAIN");
        Util.log("cost", "MAIN", end-begin);

        System.out.println(" ");

        begin =  Util.log("begin", "MAIN");
        runThread();
        end = Util.log("end", "MAIN");
        Util.log("cost", "MAIN", end-begin);

        System.out.println(" ");

        begin =  Util.log("begin", "MAIN");
        runExecutor();
        end = Util.log("end", "MAIN");
        Util.log("cost", "MAIN", end-begin);

    }

}
