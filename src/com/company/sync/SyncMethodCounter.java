package com.company.sync;
public class SyncMethodCounter implements ICounter{
    private int c = 0;

    @Override
    public synchronized void increment() {
        c++;
    }

    @Override
    public synchronized void decrement() {
        c--;
    }

    @Override
    public synchronized int value() {
        return c;
    }

}