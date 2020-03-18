package com.xiao.deng.leetcode.gcd;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        List<Integer> gcdList = gcd(str1.length(), str2.length());
        String gcdString;
        for (Integer i : gcdList) {
            gcdString = str1.substring(0, i);
            if (check(gcdString, str1) && check(gcdString, str2)) {
                return gcdString;
            }
        }
        return "";
    }

    /**
     * 检查 s1 是否为 s2 公因子 字符串
     *
     * @param s1 子字符串
     * @param s2
     * @return
     */
    private boolean check(String s1, String s2) {

        if (s2.length() % s1.length() != 0) {
            return false;
        }

        int times = s2.length() / s1.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s1);
        }
        if (sb.toString().equals(s2)) {
            return true;
        }
        return false;
    }

    private List<Integer> gcd(int l1, int l2) {
        List<Integer> list = new ArrayList<>();
        int shortLen = l1 <= l2 ? l1 : l2;
        for (int i = shortLen; i > 0; i--) {
            if (l1 % i == 0 && l2 % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "A";

        String gcbString = new Solution().gcdOfStrings(s1, s2);
        System.out.println(gcbString);
    }
}
