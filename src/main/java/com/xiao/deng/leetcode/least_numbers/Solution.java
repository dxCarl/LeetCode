package com.xiao.deng.leetcode.least_numbers;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        if (arr.length <= k) {
            return arr;
        }
        int[] least = new int[k];
        for (int i = 0; i < k; i++) {
            least[i] = arr[i];
        }
        return least;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,1};
        int k = 5;
        int[] ans = new Solution().getLeastNumbers(arr, k);
        for (int an : ans) {
            System.out.println(an);
        }

    }

}
