package com.example.javamultithread.example;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 * 线程在抛出异常InterruptedException之前，会清除该线程的中断标识
 * 正常运行的线程，调用interrupt()中断方法，中断标识会修改为true
 * 阻塞中的线程，调用interrupt()中断方法，会抛出中断异常
 *
 * @author tom
 * @version V1.0
 * @date 2021/3/21 14:00
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        // sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        // busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        System.out.println("SleepThread 中断前中断标识 is " + sleepThread.isInterrupted());
        System.out.println("BusyThread 中断前中断标识 is " + busyThread.isInterrupted());
        // 主线程休眠3秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(3);
        System.out.println("中断sleep线程");
        sleepThread.interrupt();
        System.out.println("中断busy线程");
        busyThread.interrupt();
        System.out.println("SleepThread 中断后中断标识 is " + sleepThread.isInterrupted());
        System.out.println("BusyThread 中断后中断标识 is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);

    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            SleepUtils.second(10);
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while(true){

            }
        }
    }

}
