package com.xiao.deng.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xiao
 * @date 2020/09/11
 */
public class B implements Runnable{

    LockUtil util;
    List<Long> list;

    B(LockUtil util, List<Long> list) {
        this.util = util;
        this.list = list;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        List<Long> success = util.defaultBatchTryLock(list, "t");
        System.out.println("B lock success :" + success.size());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        util.defaultBatchUnlock(success, "t");
    }
}
