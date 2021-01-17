package com.company.immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RGBTest {
    final SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Black");
    final ImmutableRGB black = new ImmutableRGB(0, 0, 0, "Black");
    @Test
    public void testSynchronizedRGB() {
        color.set(255, 255, 255, "White");
        synchronized (color) {
            int myColorInt = color.getRGB();
            String myColorName = color.getName();

            System.out.println(myColorName+myColorInt);
        }
    }

    @Test
    public void testImmutableRGB() {
        ImmutableRGB white = black.invert();
        int myColorInt = white.getRGB();
        String myColorName = white.getName();
        System.out.println(myColorName+myColorInt);

    }
}