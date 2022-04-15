package com.bingfa.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Tan Lianwang
 * @title: Shutdown
 * @date 2022/2/24 11:32
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {

        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        // 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        System.out.println("one : "+countThread.isInterrupted());

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
//         睡眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        System.out.println("TWO ON "+ two.isOn());
        System.out.println("two : "+countThread.isInterrupted());
        System.out.println(countThread);
        two.cancel();

    }


    private static class Runner implements Runnable{
        private long i;
        private volatile Boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(Thread.currentThread() + "runner");
            System.out.println(i);

        }
        public Boolean isOn(){
            return on;
        }
        public  void cancel(){
            on = false;
        }
    }
}
