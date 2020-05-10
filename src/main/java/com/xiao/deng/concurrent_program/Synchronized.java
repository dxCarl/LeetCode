package com.xiao.deng.concurrent_program;

public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {
            m();
        }
    }

    public static synchronized void m() {
    }
}
