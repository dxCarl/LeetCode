package com.xiao.deng.concurrent_program;

import java.util.concurrent.TimeUnit;

/**
 * @author xiao
 * @date 2020/05/10
 */
public class SleepUtil {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
