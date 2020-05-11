package com.xiao.deng.concurrent_program;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                SleepUtil.second(10);
            } finally {
                System.out.println("daemon finally run.");
            }
        }
    }
}
