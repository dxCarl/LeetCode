package com.xiao.deng.design_pattern;

/**
 * 饿汉模式
 * 不能懒加载
 * 线程安全
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {

        return instance;
    }
}
