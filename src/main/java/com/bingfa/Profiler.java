package com.bingfa;

import java.util.concurrent.TimeUnit;

/**
 * @author Tan Lianwang
 * @title: Profiler
 * @date 2022/2/24 17:46
 */
public class Profiler {

    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        System.out.println(Thread.currentThread().getName());

        TIME_THREADLOCAL.set(System.currentTimeMillis());

    }

    public static final long end() {
        System.out.println(Thread.currentThread().getName());

        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
