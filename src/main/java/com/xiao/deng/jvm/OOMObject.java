package com.xiao.deng.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * -Xms100M -Xmx100M -XX:+UseSerialGC
 *
 * @author xiao
 * @date 2020/10/24
 */
public class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("add: " + i);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
