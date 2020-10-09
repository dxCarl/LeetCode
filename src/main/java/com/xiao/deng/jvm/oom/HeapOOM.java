package com.xiao.deng.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiao
 * @date 2020/10/01
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            Thread.sleep(3000);
        }
    }

}
