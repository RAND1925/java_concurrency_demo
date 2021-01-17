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
        while (!Thread.interrupted()) {
            try {
                System.out.println("run");
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("interrupted");

        long end = Util.log("end", arg);
        Util.log("cost", arg, (end - begin));
    }

}