package com.bingfa;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Tan Lianwang
 * @title: Demo
 * @date 2022/3/16 15:12
 */
public class Demo {
        private static AtomicLong threadNum = new AtomicLong();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(threadNum.incrementAndGet());
        }
    }
}
