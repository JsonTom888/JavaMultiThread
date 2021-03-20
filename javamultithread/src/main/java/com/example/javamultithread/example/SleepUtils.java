package com.example.javamultithread.example;

import java.util.concurrent.TimeUnit;

/**
 * @author tom
 * @version V1.0
 * @date 2021/3/20 21:46
 */
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
