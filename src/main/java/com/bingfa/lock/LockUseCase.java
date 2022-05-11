package com.bingfa.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Tan Lianwang
 * @title: LockUseCase
 * @date 2022/4/15 14:04
 */
public class LockUseCase {
    public static void main(String[] args) throws InterruptedException {
//        AbstractQueuedSynchronizer 队列同步器
        Lock lock = new ReentrantLock();
        //“不要将获取锁的过程写在try块中，因为如果在获取锁（自定义锁的实现）时发生了异常，异常抛出的同时，也会导致锁无故释放”
        lock.lock();
        lock.tryLock();
        lock.lockInterruptibly();
        Condition condition = lock.newCondition();
        condition.await();
        try{
            System.out.println("hello");
        }finally {
            lock.unlock();
        }
    }
}
