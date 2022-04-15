package com.bingfa.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Tan Lianwang
 * @title: SleepUtils
 * @date 2022/2/23 16:23
 */
public class SleepUtils {
    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ignored) {
        }
    }
}
