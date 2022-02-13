package com.xiao.deng.leetcode.dynamic_programming;

/**
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * @author xiao
 */
public class FibonacciNumber {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fibResult = new int[n];
        fibResult[0] = 0;
        fibResult[1] = 1;
        int i = 2;
        while (i < n) {
            fibResult[i] = fibResult[i - 1] + fibResult[i - 2];
            i++;
        }
        return fibResult[n-1] + fibResult[n-2];
    }

    public static void main(String[] args) {
        int n = 6;
        final int fib = fib(n);
        System.out.println(fib);
    }

}
