package com.xiao.deng.leetcode.sort_array;

import java.util.Arrays;

public class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        int[] ans = new Solution().sortArray(nums);
        System.out.println(ans.toString());
    }
}
