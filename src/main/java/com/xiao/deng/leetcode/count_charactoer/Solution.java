package com.xiao.deng.leetcode.count_charactoer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    /**
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     * 注意：每次拼写时，chars 中的每个字母都只能用一次。
     * 返回词汇表 words 中你掌握的所有单词的 长度之和
     * <p>
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     * <p>
     * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * 输出：10
     * 解释：
     * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        if ("" == chars || words.length == 0) {
            return 0;
        }
        char[] charsArr = chars.toCharArray();
        Map<Character, Integer> charMap = arr2Map(charsArr);
        int total = 0;

        for (String str : words) {
            char[] wordArr = str.toCharArray();
            Map<Character, Integer> wordMap = arr2Map(wordArr);
            boolean contain = true;
            Iterator<Map.Entry<Character, Integer>> iterator = wordMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                char key = entry.getKey();
                int count = entry.getValue();
                if (!charMap.containsKey(key) || charMap.get(key) < count) {
                    contain = false;
                    break;
                }
            }

            if (contain) {
                total += wordArr.length;
            }
        }


        return total;
    }

    private Map<Character, Integer> arr2Map(char[] chars) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (charMap.containsKey(c)) {
                int count = charMap.get(c);
                charMap.put(c, count + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        return charMap;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"hello", "world", "leetcode"};
        String chars = "";
        int count = new Solution().countCharacters(words, chars);
        System.out.println(count);
    }
}
