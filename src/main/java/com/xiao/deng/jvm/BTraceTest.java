package com.xiao.deng.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xiao
 * @date 2020/10/24
 */
public class BTraceTest {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BTraceTest traceTest = new BTraceTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            System.out.println("input : " + s);
            int a = (int) Math.round(Math.random() * 100);
            int b = (int) Math.round(Math.random() * 100);
            System.out.println(traceTest.add(a, b));
        }
    }
}
