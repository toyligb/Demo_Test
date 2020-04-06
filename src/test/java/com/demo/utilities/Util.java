package com.demo.utilities;

public class Util {

    public static void sleep(int sec) {
        int millis = sec * 1000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
