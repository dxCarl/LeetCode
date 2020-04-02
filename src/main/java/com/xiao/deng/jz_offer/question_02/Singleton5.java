package com.xiao.deng.jz_offer.question_02;

/**
 * 高效静态构造函数 单例模式
 */
public class Singleton5 {
    public Singleton5 getInstance() {
        return new Nested().instance;
    }


    private class Nested {
        final Singleton5 instance = new Singleton5();
    }

}
