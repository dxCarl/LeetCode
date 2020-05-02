package com.xiao.deng.jz_offer.question_02;

/**
 * 多线程下 单例模式
 * <p>
 * 高效
 */
public class Singleton3 {
    private static final Object obj = new Object();

    private static Singleton3 instance = null;

    public Singleton3 getInstance() {
        if (null == instance) {
            synchronized (obj) {
                if (null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
