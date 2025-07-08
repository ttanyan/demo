package com.jimi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Tan Lianwang
 * @title: ThreadTest
 * @date 2022/8/3 11:28
 */
public class ThreadTest {

     int i = 0;
    ExecutorService executorService = Executors.newCachedThreadPool();
    public void test(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(++i);
                System.out.println(++i);
                System.out.println(++i);
                System.out.println(++i);
                System.out.println(++i);
            }
        });
    }

    public static void main(String[] args) {
       String s = "1,2,4";
        System.out.println(s.replace(",","#"));
        System.out.println(s.split(",").length);


    }
}
