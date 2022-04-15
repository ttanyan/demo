package com.bingfa.thread;

/**
 * @author Tan Lianwang
 * @title: Synchronized
 * @date 2022/2/24 13:54
 */
public class Synchronized {
     public static void main(String[] args) {
        // 对Synchronized Class对象进行加锁
        synchronized (Synchronized.class) {
        }
        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
         Synchronized aSynchronized = new Synchronized();
         aSynchronized.n();
     }
    public static synchronized void m() {
    }

    public synchronized void n(){

    }
}
