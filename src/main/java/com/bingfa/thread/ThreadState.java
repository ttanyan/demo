package com.bingfa.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author Tan Lianwang
 * @title: MulitiThread
 * @date 2022/2/23 16:21
 */
public class ThreadState {


    public static void main(String[] args) {

        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();


    }

    // 该线程不断地进行睡眠
    static class TimeWaiting implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                TimeUnit.SECONDS.sleep(1000);
            }
        }
    }

    // 该线程在Waiting.class实例上等待
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                        Waiting.class.notify();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程在Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable {
        public void run() {

            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }
}
