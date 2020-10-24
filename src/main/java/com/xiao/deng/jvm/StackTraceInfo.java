package com.xiao.deng.jvm;

import java.util.Map;

/**
 * @author xiao
 * @date 2020/10/24
 */
public class StackTraceInfo {
    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] elements = entry.getValue();
            if (thread.equals((Thread.currentThread()))) {
                continue;
            }
            System.out.println("thread name :" +  thread.getName());
            for (StackTraceElement element : elements) {
                System.out.println(element);
            }
        }
    }
}
