package com.xiao.deng.jz_offer.question_02;

/**
 * 单例模式
 * <p>
 * 静态构造函数方式
 */
public class Singleton4 {
    private static Singleton4 instance = null;

    static {
        instance = new Singleton4();
    }

    public Singleton4 getInstance() {
        return instance;
    }
}
