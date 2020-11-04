package com.company;

import com.company.util.Util;

public class Main {
    public static final int times = 20;

    public static void thread() throws InterruptedException {
        Thread[] threads = new Thread[times];
        //Counter counter = new Counter();
        Counter counter = new Counter();
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);
            Thread thread = new Thread(new Task(counter), "thread"+ si);
            threads[i] = thread;
            thread.start();
            // thread.join(); // not like this caz it may
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
