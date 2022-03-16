package com.bingfa;

import java.util.concurrent.CountDownLatch;

/**
 * @author Tan Lianwang
 * @title: QueueTask
 * @date 2022/3/16 10:10
 */
public class CountDownTest {
    public static void main(String[] args) throws InterruptedException {
        long millis = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new SeeDoctorTask(countDownLatch)).start();
        new Thread(new QueueTask(countDownLatch)).start();
        countDownLatch.await();
        System.out.println(System.currentTimeMillis()-millis);

    }




    static  class  QueueTask implements Runnable{
        private CountDownLatch countDownLatch;

        public QueueTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("开始排队买药");
                Thread.sleep(5000);
                System.out.println("排队成果缴费");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if(countDownLatch != null){
                    countDownLatch.countDown();
                }
            }
        }
    }


    static class SeeDoctorTask implements Runnable{

        private CountDownLatch countDownLatch;

        public SeeDoctorTask(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("开始看医生");
                Thread.sleep(3000);
                System.out.println("看医生结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if(countDownLatch != null){
                    countDownLatch.countDown();
                }
            }

        }
    }
}
