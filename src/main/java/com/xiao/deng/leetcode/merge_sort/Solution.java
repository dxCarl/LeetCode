package com.xiao.deng.leetcode.merge_sort;

public class Solution {

    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * 初始化 A 和 B 的元素数量分别为 m 和 n
     * <p>
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        int[] merge = new int[m + n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            while (i < m && j < n) {
                int a = A[i];
                int b = B[j];
                if (a < b) {
                    merge[k++] = a;
                    i++;
                } else {
                    merge[k++] = b;
                    j++;
                }
            }
            if (i == m) {
                merge[k] = B[j++];
            }else {
                merge[k] = A[i++];
            }

        }
        A = merge;
        for (int z = 0; z < m + n; z++) {
            System.out.println(A[z]);
        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 6, 0, 0, 0};
        int[] B = new int[]{1, 2, 3};
        Solution.merge(A, 3, B, 3);
    }
}
