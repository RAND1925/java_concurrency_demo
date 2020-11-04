package com.company;

import java.util.concurrent.TimeUnit;
import com.company.util.Util;
public class Task implements Runnable {
    private String arg;

    public Task(String arg) {
        this.arg = arg;
    }
    public Task() {
        this("noname");
    }
    public void setArg(String arg) {
        this.arg = arg;
    }

    @Override
    public void run()  {
        long begin =  Util.log("begin", arg);
        // Do something during 1 sec
        try {
            TimeUnit.SECONDS.sleep(1);  // 10
        } catch (InterruptedException e) {
            System.out.println("intrrupt");
        }
        long end = Util.log("end", arg);
        Util.log("cost", arg, (end - begin));
    }

}
