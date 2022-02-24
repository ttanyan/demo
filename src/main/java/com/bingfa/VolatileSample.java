package com.bingfa;

/**
 * @author Tan Lianwang
 * @title: VolatileSample
 * @date 2022/1/24 17:56
 */
public class VolatileSample {

    public static volatile int  i = 0;

    public static void insace(){
        i++;
        String name = Thread.currentThread().getName();
        System.out.println("线程 " + name + "读取到的i值为："+i);
    }

    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o){

        }
        for (int j = 0; j < 1000; j++) {
            Thread thread = new Thread(() -> {
                VolatileSample.insace();
            }, "ThreadB " + i);


            Thread thread1 = new Thread(() -> {
                VolatileSample.insace();
            },"ThreadA "+i);


                thread.start();
                thread1.start();


        }



    }
}
