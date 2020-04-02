package com.xiao.deng.jz_offer.question_02;

/**
 * 多线程下 单例模式
 * <p>
 * 低效
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    private static final Object obj = new Object();

    public Singleton2 getInstance() {
        synchronized (obj) {
            if (null == instance) {
                instance = new Singleton2();
            }
        }
        return instance;
    }
}
