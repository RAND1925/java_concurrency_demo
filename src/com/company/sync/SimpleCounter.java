package com.company.sync;
public class SimpleCounter implements ICounter{
    private int c = 0;

    @Override
    public void increment() {
        c++;
    }

    @Override
    public void decrement() {
        c--;
    }

    @Override
    public int value() {
        return c;
    }

}