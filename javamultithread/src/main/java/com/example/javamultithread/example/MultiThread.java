package com.example.javamultithread.example;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 使用JMX来查看一个普通的Java程序包括哪些线程
 *
 * @author tom
 * @version V1.0
 * @date 2021/3/20 20:57
 */
public class MultiThread {

    public static void main(String[] args) {
        // 获取Java线程管理的MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息。
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "]" +
                    threadInfo.getThreadName());
        }
    }

}
