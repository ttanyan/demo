package com.jimi.java8.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author test
 */
public class ParallelStreamAndStream {
    public static void main(String[] args) {
        List<Integer> i = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("stream.forEach打印结果如下(有序)");
        i.stream().forEach(System.out::println);
        System.out.println("parallelStream.forEach打印结果如下(无序)");
        i.parallelStream().forEach(System.out::println);
        System.out.println("parallelStream.forEachOrdered打印结果如下(有序.结果同stream.forEac)");
        i.parallelStream().forEachOrdered(System.out::println);


        //模拟10000条数据 循环打印测试
        List<Integer> list = new ArrayList();
        for (int j = 0; j < 1000; j++) {
            list.add(j);
        }
        // 统计并行执行list的线程
        Set<Thread> threadSet = new CopyOnWriteArraySet<>();
        // 并行执行
        list.parallelStream().forEach(integer -> {
            Thread thread = Thread.currentThread();
            // 统计并行执行list的线程
            threadSet.add(thread);
        });
        System.out.println(threadSet);
        //打印结果由此证明parallelStream是多管道线程
        System.out.println("threadSet一共有" + threadSet.size() + "个线程");
        System.out.println("系统一个有" + Runtime.getRuntime().availableProcessors() + "个cpu");

        list.parallelStream().forEach(System.out::println);


    }
}
