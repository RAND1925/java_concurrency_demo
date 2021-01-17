package com.company.sync;

public class SyncStatementCounter implements ICounter{
    private int c;
    private final Object lock = new Object();

    // useful if there are more than one data field.
    private Object lock2 = new Object();

    @Override
    public void increment() {
        synchronized (lock) {
            c++;
        }
    }

    @Override
    public void decrement() {
        synchronized (lock) {
            c--;
        }
    }

    @Override
    public int value() {
        synchronized (lock) {
            return c;
        }
    }

}
