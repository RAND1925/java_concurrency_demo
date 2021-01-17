package com.company.sync;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements ICounter{
    private AtomicInteger c = new AtomicInteger(0);
    @Override
    public void increment() {
        c.incrementAndGet();
    }

    @Override
    public void decrement() {
        c.decrementAndGet();
    }

    @Override
    public int value() {
        return c.get();
    }
}
