package com.bingfa.thread;

/**
 * @author Tan Lianwang
 * @title: DeadLockDemo
 * @date 2022/1/26 11:18
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
//        Singleton singleton = new Singleton();
    }

    private void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                 try{
                    Thread.currentThread().sleep(2000);

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                    synchronized(B) {
                        System.out.println("1");
                    }

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println(2);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();


    }
}

