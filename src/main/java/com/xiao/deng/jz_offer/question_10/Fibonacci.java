package com.xiao.deng.jz_offer.question_10;

/**
 * 求斐波那契数列第n项
 */
public class Fibonacci {
    public long fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacci2(int n) {
        Long[] arr = new Long[n + 1];
        arr[0] = 1L;
        arr[1] = 1L;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];

    }

    public static void main(String[] args) {
        int n = 10;
        Fibonacci fib = new Fibonacci();
        long ans = fib.fibonacci(n);
        long ans2 = fib.fibonacci2(n);
        System.out.println(ans);
        System.out.println(ans2);
    }

}
