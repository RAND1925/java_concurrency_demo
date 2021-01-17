package com.company.basic;

import com.company.basic.Task;
import com.company.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RunnerTest {
    private long begin;
    private long end;
    private int times = 10;

    @BeforeEach
    public void beginTest(){
        begin =  Util.log("begin", "MAIN");
    }

    @AfterEach
    public void endTEst() {
        end = Util.log("end", "MAIN");
        Util.log("cost", "MAIN", end-begin);
        System.out.println(" ");
    }

    @Test
    public void testRunDirectly() {
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);
            new Task(si).run();
        }
    }

    @Test
    public void testRunThread() throws InterruptedException {
        // create *times* threads
        Thread[] threads = new Thread[times];
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);
            Thread thread = new Thread(new Task(si), "thread"+ si);
            threads[i] = thread;
            thread.start();
            // thread.join();
        }
        for (Thread thread: threads) {
            thread.join();
        }
    }

    @Test
    void testRunExecutor() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < times; ++i) {
            String si = String.valueOf(i);
            pool.execute(new Task((si)));
        }
        pool.shutdown();
        try {
            boolean res = pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}