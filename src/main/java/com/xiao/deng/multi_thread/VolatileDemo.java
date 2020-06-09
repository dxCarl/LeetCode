package com.xiao.deng.multi_thread;

import com.xiao.deng.leetcode.diameter_of_binary_tree.TreeNode;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    static volatile Boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {

            }
            System.out.printf("********** %s 线程执行结束！**********", Thread.currentThread().getName());
        }, "thread a").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("********** %s 线程执行结束！**********", Thread.currentThread().getName());

        }, "thread b").start();
    }
}
