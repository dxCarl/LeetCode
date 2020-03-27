package com.xiao.deng.leetcode.dynamic_programming;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        int rev = x;
        int val = 0;
        while (rev > 0) {
            int d = rev % 10;
            val = val * 10 + d;
            rev = rev / 10;
        }
        System.out.println(val);
        return x == val;
    }

    public static void main(String[] args) {
        int x = 10;
        boolean ans = new Palindrome().isPalindrome(x);

        System.out.println(ans);
    }
}
