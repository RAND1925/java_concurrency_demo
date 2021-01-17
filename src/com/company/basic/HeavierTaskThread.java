package com.company.basic;

import java.util.concurrent.TimeUnit;
import com.company.util.Util;
public class HeavierTaskThread extends Thread {
    private String arg;

    public HeavierTaskThread(String arg) {
        this.arg = arg;
    }

    @Override
    public void run() {
        long begin = Util.log("begin", arg);
        // Do something during 1 sec
        try {
            TimeUnit.MILLISECONDS.sleep(10000000);

        } catch (InterruptedException e) {
            if (Thread.interrupted()) {
                System.out.println("interrupted");
                Util.log( "interrupted", "sth happened");
                return;
            }
        }
        long end = Util.log("end", arg);
        Util.log("cost", arg, (end - begin));
    }

}