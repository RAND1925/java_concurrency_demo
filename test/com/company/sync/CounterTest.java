package com.company.sync;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @Test
    public void testCounter() throws InterruptedException {
        ICounter simpleCounter = new SimpleCounter();
        ICounter atomicCounter = new AtomicCounter();
        ICounter syncMethodCounter = new SyncMethodCounter();
        ICounter syncStatementCounter = new SyncStatementCounter();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    simpleCounter.increment();
                    atomicCounter.increment();
                    syncMethodCounter.increment();
                    syncStatementCounter.increment();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("simple "+simpleCounter.value()); // problems
        System.out.println("atomic "+atomicCounter.value());
        System.out.println("sync M "+syncMethodCounter.value());
        System.out.println("sync S "+syncStatementCounter.value());
        assertEquals(10000,simpleCounter.value());

    }
}