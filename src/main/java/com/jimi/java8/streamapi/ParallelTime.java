package com.jimi.java8.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @author test
 */
public class ParallelTime {

    public static void main(String[] args) throws InterruptedException {

        //模拟10000条数据 forEach打印测试
        List<Integer> list = new ArrayList();
        for (int j = 0; j < 10000; j++) {
            list.add(j);
        }


        long startTime = System.currentTimeMillis();
        //传统for循环
        for (int i = 0; i < list.size(); i++) {
            try {
                //睡眠1毫秒
//                TimeUnit.MILLISECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("传统for循环运行时间:" + (endTime - startTime) + "ms");

        // 测试单管道stream执行效率
        startTime = System.currentTimeMillis();
        list.stream().forEach(r -> {
            try {
                //睡眠1毫秒
//                TimeUnit.MILLISECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long streamendTime = System.currentTimeMillis();
        System.out.println("stream : " + (streamendTime - startTime) + "ms");

        // 测试多管道parallelStream执行效率
        startTime = System.currentTimeMillis();
        Set<Thread>  threads = new CopyOnWriteArraySet<>();
        list.parallelStream().forEach(r -> {
            try {
                Thread thread = Thread.currentThread();
                threads.add(thread);

                //睡眠1毫秒
//                TimeUnit.MILLISECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long parallelStreamendTime = System.currentTimeMillis();
        System.out.println("parallelStream : " + (parallelStreamendTime - startTime) + "ms");
        System.out.println("系统创建了"+threads.size()+"个线程");


    }
}
