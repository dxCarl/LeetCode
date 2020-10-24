package com.xiao.deng.jvm.oom;

/**
 * @author xiao
 * @date 2020/10/08
 */
public class JavaVMStackSOF {
    private int stackLenth = 1;

    public void stackLeak() {
        stackLenth++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom  = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }
        catch (Throwable throwable) {
            System.out.println("stack length: " + oom.stackLenth);
            throw throwable;
        }
    }
}
