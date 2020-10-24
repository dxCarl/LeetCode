package com.xiao.deng.jvm.gc;

/**
 * @author xiao
 * @date 2020/10/11
 */
public class ReferenceCountingGc {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * 1024];

    public static void main(String[] args) {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();

        objA.instance = objA;
        objB.instance = objB;

        objA = null;
        objB = null;

        System.gc();
    }
}
