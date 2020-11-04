package com.company;

import com.company.util.Util;

public class Main {
    public static final int times = 20;

    private static void nonCurrencecy() {
        for (int i = 0; i < times; ++i) {
            new Task(String.valueOf(i)).run();
        }

    }

    public static void thread() throws InterruptedException {
        Thread[] threads = new Thread[times];
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);

            Thread thread = new Thread(new Task(si), "thread"+ si);
            threads[i] = thread;
            thread.start();
            // thread.join(); // not like this caz it may
            if (i == 4) { // maybe thread 4 costs so much time
                thread.interrupt();
            }
        }
        for (Thread thread: threads) {
            thread.join(1000);
        }

    }


    public static void main(String[] args) throws InterruptedException {
        long begin =  Util.log("begin", "MAIN");
        thread();
        long end = Util.log("end", "MAIN");

        Util.log("cost", "MAIN", end-begin);
    }

}
