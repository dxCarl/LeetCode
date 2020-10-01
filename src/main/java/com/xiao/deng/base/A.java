package com.xiao.deng.base;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author xiao
 * @date 2020/09/11
 */
public class A implements Runnable{
    LockUtil util;
    List<Long> list;

    A(LockUtil util, List<Long> list) {
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
    @SneakyThrows
    @Override
    public void run() {
        List<Long> success = util.defaultBatchTryLock(list, "t");
        System.out.println("A lock success :" + success.size());
        Thread.sleep(5000);
        util.defaultBatchUnlock(success, "t");
    }
}
