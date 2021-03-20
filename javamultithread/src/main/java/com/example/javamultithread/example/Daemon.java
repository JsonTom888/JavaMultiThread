package com.example.javamultithread.example;

/**
 * 守护线程
 * 在主线程启动守护线程后，主线程结束，这时没有非守护线程在运行，所以程序退出
 * 守护线程在终端无任何输出
 *
 * @author tom
 * @version V1.0
 * @date 2021/3/20 22:11
 */
public class Daemon {
    public static void main(String[] args)  {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finaly run.");
            }
        }
    }
}
