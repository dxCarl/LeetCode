package com.xiao.deng.jvm;

import java.util.Random;

/**
 * @author xiao
 * @date 2020/06/13
 */
public class Memory {

    /**
     * -Xms1024m -Xmx1024m -XX:+PrintGCDetails
     *
     * @param args
     */
    public static void main(String[] args) {
//        long l = Runtime.getRuntime().maxMemory();
//        long l1 = Runtime.getRuntime().totalMemory();
//        System.out.println("max: " + l / (double) (1024 * 1024));
//        System.out.println("total: " + l1 / (double) (1024 * 1024));

        String hello = "xxxxxxxxxdfdafdf";
        while (true) {
            hello   += hello + new Random().nextInt(88888) + new Random().nextInt(9999);
        }
    }
}
