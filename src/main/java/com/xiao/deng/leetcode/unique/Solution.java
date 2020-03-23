package com.xiao.deng.leetcode.unique;

import java.util.*;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * <p>
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * <p>
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class Solution {
    public int minIncrementForUnique(int[] A) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            int key = A[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int cnt = 0;
        int[] arr = new int[4001];
        int min = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {

                min = entry.getValue();
                cnt += min - 1;
                // todo  unfinished

            }
        }
        return 0;
    }
}
