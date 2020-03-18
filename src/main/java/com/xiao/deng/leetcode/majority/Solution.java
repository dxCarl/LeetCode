package com.xiao.deng.leetcode.majority;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出:
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = nums[i];
            if (countMap.containsKey(key)) {
                int count = countMap.get(key);
                if (count >= (len - 1) / 2) {
                    return key;
                }
                countMap.put(key, count + 1);
            } else {
                countMap.put(key, 1);
            }
        }
        int maxCount = 0;
        int maxKey = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = countMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();

            int value = entry.getValue();
            int key = entry.getKey();
            if (value >= maxCount) {
                maxKey = key;
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        int ans = new Solution().majorityElement(nums);
        System.out.println(ans);
    }
}
