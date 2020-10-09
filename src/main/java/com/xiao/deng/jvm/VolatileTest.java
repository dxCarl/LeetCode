package com.xiao.deng.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiao
 * @date 2020/10/03
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }
    private static final int THREAD_COUNTS = 20;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNTS];
        for (int i = 0; i < THREAD_COUNTS; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    increase();
                    atomicInteger.getAndIncrement();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
        System.out.println(atomicInteger);
    }
}
