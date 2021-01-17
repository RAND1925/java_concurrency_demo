package com.company.basic;

import org.junit.jupiter.api.Test;

public class InterruptTest {
    @Test
    public void testInterrupt() throws InterruptedException {
        Thread testThread = new HeavierTaskThread("Interrupt");
        //start thread
        testThread.start();
        Thread.sleep(1000);
        testThread.interrupt();

    }

}
