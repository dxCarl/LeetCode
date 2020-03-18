package com.xiao.deng.leetcode.three_parts;

public class Solution {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }

        int left = 0;
        int right = A.length - 1;
        int leftSum = A[left];
        int rightSum = A[right];

        while (left + 1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                return true;
            }
            if (leftSum != sum / 3) {
                leftSum += A[++left];
            }

            if (rightSum != sum / 3) {
                rightSum += A[--right];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        boolean ans = new Solution().canThreePartsEqualSum(A);
        System.out.println(ans);
    }
}
