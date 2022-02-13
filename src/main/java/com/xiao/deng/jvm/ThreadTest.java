package com.xiao.deng.jvm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ThreadTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread t = new Thread(() -> {
            long count = 0;
            while (true) {
                count++;
                if (count % (1000 * 1000 * 1000) == 0) {
                    System.out.println("count=" + count);
                }
            }
        });

        t.start();
        System.out.println("thread start");
        System.in.read();
        t.interrupt();
        System.out.println("thread interrupt");
        TimeUnit.SECONDS.sleep(2);
        System.in.read();
        System.out.println("thread stop");
        t.stop();
        System.in.read();
    }
}
