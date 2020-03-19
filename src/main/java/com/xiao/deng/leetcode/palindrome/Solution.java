package com.xiao.deng.leetcode.palindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010
 * <p>
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7
 */
public class Solution {
    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        Map<Character, Boolean> isOddCharMap = new HashMap<>();
        for (char c : chars) {
            if (isOddCharMap.containsKey(c)) {
                isOddCharMap.remove(c);
            } else {
                isOddCharMap.put(c, true);
            }
        }
        int oddCount = isOddCharMap.keySet().size();
        int len = s.length();
        return oddCount > 0 ? len - oddCount + 1 : len;
    }

    public static void main(String[] args) {
        String s = "a";
        int ans = new Solution().longestPalindrome(s);
        System.out.println(ans);
    }
}
