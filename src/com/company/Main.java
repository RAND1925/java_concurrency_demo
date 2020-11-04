package com.company;

import com.company.util.Util;

public class Main {
    public static final int times = 20;

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


    public static void main(String[] args) throws InterruptedException {
        long begin =  Util.log("begin", "MAIN");
        //runThread();
        runNonConcurrency();
        long end = Util.log("end", "MAIN");

        Util.log("cost", "MAIN", end-begin);
    }

}
