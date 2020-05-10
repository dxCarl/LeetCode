package com.xiao.deng.concurrent_program;

import java.util.concurrent.TimeUnit;

public class Profiler {
    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<>();

    private static Long initValue() {
        return System.currentTimeMillis();
    }

    public static final void begin() {
        TIME_THREAD_LOCAL.set(initValue());
    }

    public static final Long end() {
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost " + Profiler.end() + " mills");

    }
}
