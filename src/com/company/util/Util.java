package com.company.util;

public class Util {
    public static long log(String status, String name) {
        long currentTimeMillis =  System.currentTimeMillis();
        log(status, name, currentTimeMillis);
        return currentTimeMillis;
    }

    public static long log(String status, String name, long time) {
        String currentThread = Thread.currentThread().getName();
        String formatted = String.format("%d\t%s\t%s\t%s", time, currentThread, status, name);
        System.out.println(formatted);
        return time;
    }

}
