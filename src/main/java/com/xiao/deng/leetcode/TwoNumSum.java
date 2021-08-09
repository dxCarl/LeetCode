package com.xiao.deng.leetcode;


public class TwoNumSum {
    public static void main(String[] args) {
        int cap = 10;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int rs = (n < 0) ? 1 : (n >= 10) ? 10 : n + 1;
        System.out.println(rs);

    }
}
