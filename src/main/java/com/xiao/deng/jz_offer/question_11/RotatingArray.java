package com.xiao.deng.jz_offer.question_11;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 把一个数组最开始点若干个元素搬到数组点末尾。我们称之为数组点旋转
 * 输入一个递增排序的数组点一个旋转， 输出旋转数组中最小元素。
 * 例如：
 * 数组｛3，4，5，1，2｝ 为｛1，2，3，4，5｝ 点一个旋转， 该数组点最小值为1
 */
public class RotatingArray {
    public int min(int[] arr) {

        if (arr.length > 0) {
            int cur;
            int last = arr[0];
            if (arr[0] < arr[arr.length - 1]) {
                return arr[0];
            }

            for (int i = 0; i < arr.length; i++) {
                cur = arr[i];
                if (cur < last) {
                    return cur;
                }
                last = cur;
            }
        }
        return 0;
    }

    public int min2(int[] arr) {
        if (arr.length > 0) {
            int start = 0;
            int end = arr.length - 1;
            int mid = start;
            if (arr[start] < arr[end]) {
                return arr[start];
            }
            while (start <= mid && mid < end && arr[start] > arr[end]) {

                mid = start + end / 2;
                if (arr[mid] > arr[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            return arr[end];

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 1, 2};
        RotatingArray rotatingArray = new RotatingArray();
        int ans = rotatingArray.min(arr);
        int ans2 = rotatingArray.min2(arr);
        System.out.println(ans);
        System.out.println(ans2);

    }
}
