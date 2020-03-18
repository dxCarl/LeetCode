package com.xiao.deng.leetcode.compress;

public class Solution {
    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）
     * <p>
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * <p>
     * 输入："abbccd"
     * 输出："abbccd"
     * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     *
     * @param S
     * @return
     */
    public String compressString(String S) {
        char[] chars = S.toCharArray();
        if (chars.length == 0) {
            return "";
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < chars.length) {
            int count = 1;
            char cur = chars[i];
            int j = i+1;
            if (j == chars.length) {
                sb.append(cur);
                sb.append(1);
                break;
            }
            for (; j < chars.length; j++) {
                char comp = chars[j];
                if (cur == comp) {
                    count++;
                    if (j == chars.length - 1) {
                        sb.append(cur);
                        sb.append(count);
                        i = chars.length;
                        break;
                    }
                }
                else {
                    sb.append(cur);
                    sb.append(count);
                    i = j;
                    break;
                }
            }
        }

        String compressStr = sb.toString();
        int len = compressStr.length();
        return len < S.length() ? compressStr : S;
    }

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        String ans = new Solution().compressString(s);
        System.out.println(ans);
    }
}
