package com.example.javamultithread.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 通过设置线程优先级，测试在不同的操作系统上对线程优先级的规划，
 * 有的操作系统会忽略对线程优先级的设定。
 * 说明线程优先级不能作为程序正确性的依赖，因为操作系统可以完全
 * 不用理会Java对于线程优先级的设定。
 *
 * @author tom
 * @version V1.0
 * @date 2021/3/20 21:16
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++){
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job,"Thread:" + i);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for (Job job : jobs){
            System.out.println("Job Priority : " + job.priority + ", Count : " + job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int priority;
        private long jobCount;
        public Job(int priority){
            this.priority = priority;
        }

        @Override
        public void run() {
            while(notStart){
                Thread.yield();
            }
            while(notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }

}
