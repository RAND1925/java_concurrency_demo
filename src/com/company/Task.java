package com.company;

import java.util.concurrent.TimeUnit;
import com.company.util.Util;
public class Task implements Runnable {
    private String arg;

    public Task(String arg) {
        this.arg = arg;
    }

    @Override
    public void run()  {
        long begin =  Util.log("begin", arg);
        // Do something during 1 sec
        try {
            Thread.sleep(1000); // task 1 second
            // the same as TimeUnit.MILLISECONDS.sleep(1000);

        } catch (InterruptedException e) {
            if (Thread.interrupted()) {
                Util.log( "interrupted", "sth happened");
                return;
            }
        }
        long end = Util.log("end", arg);
        Util.log("cost", arg, (end - begin));
    }

}
