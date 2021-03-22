package com.example.javamultithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock的简单使用
 *
 * @author tom
 * @version V1.0
 * @date 2021/3/22 21:19
 */
public class LockUseCase {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
        }finally{
            lock.unlock();
        }
    }

}
