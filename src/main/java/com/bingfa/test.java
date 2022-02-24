package com.bingfa;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Tan Lianwang
 * @title: test
 * @date 2022/2/9 10:12
 */
public class test {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        ReentrantLock lock1 = new ReentrantLock(false);
        lock.lock();
        lock.unlock();
        lock1.lock();

        Thread.interrupted();
    }
}
