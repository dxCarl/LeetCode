package com.xiao.deng.jz_offer.question_02;

/**
 * 仅适用于单线程
 */
public class Singleton {

    private static Singleton instance = null;

    public Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }
}
