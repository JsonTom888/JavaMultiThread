package com.example.javamultithread.example;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal的使用
 *
 * @author tom
 * @version V1.0
 * @date 2021/3/21 16:46
 */
public class ThreadLocalProfiler {

    // 第一次get()方法调用时会进行初始化（如果set方法没有调用),每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalProfiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ThreadLocalProfiler.end() + " mills");
    }

}
