package com.xiao.deng.jz_offer.question_05;

public class ReplaceBlank {
    /**
     * @param chars 字符串转化后的字符数组
     * @param len   字符数组点总容量
     */
    public void replaceBlank(char[] chars, int len) {
        if (null == chars || len <= 0) {
            return;
        }
        int originalLen = 0;
        int numOfBlank = 0;
        int idx = 0;
        while (chars[idx] != '\0') {
            ++originalLen;
            if (chars[idx] == ' ') {
                ++numOfBlank;
            }
            ++idx;
        }

        int newLen = originalLen + numOfBlank * 2;
        if (newLen > len) {
            return;
        }

        int idxOfOriginal = originalLen;
        int idxOfNew = newLen;
        while (idxOfOriginal >= 0 && idxOfNew >= idxOfOriginal) {
            if (chars[idxOfOriginal] == ' ') {
                chars[idxOfNew--] = '0';
                chars[idxOfNew--] = '2';
                chars[idxOfNew--] = '%';
            } else {
                chars[idxOfNew--] = chars[idxOfOriginal];
            }
            --idxOfOriginal;
        }
    }
}
