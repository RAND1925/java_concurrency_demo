package com.company;

import java.util.concurrent.TimeUnit;
import com.company.util.Util;
public class Task implements Runnable {
    private final Counter counter;

    public Task(Counter counter) {
        this.counter = counter;
    }

    public void synchronized_method() {
        synchronized(this.counter) {
            long begin = Util.log("begin", String.valueOf(counter.value()));
            counter.increment();
            long end = Util.log("end  ", String.valueOf(counter.value()));

        }
    }

    public void method() {
        long begin = Util.log("begin", String.valueOf(counter.value()));
        counter.increment();
        long end = Util.log("end  ", String.valueOf(counter.value()));
    }

    public void run()  {
        //method();
        synchronized_method();
    }

}
