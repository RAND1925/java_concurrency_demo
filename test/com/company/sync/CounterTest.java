package com.company.sync;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @Test
    public void testCounter() {
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
        System.out.println("simple "+simpleCounter.value()); // problems
        assertEquals(10000,simpleCounter.value());
        System.out.println("atomic "+atomicCounter.value());
        System.out.println("sync M "+syncMethodCounter.value());
        System.out.println("sync S "+syncStatementCounter.value());
    }
}