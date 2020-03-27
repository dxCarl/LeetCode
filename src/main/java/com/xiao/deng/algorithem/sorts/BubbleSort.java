package com.xiao.deng.algorithem.sorts;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortsUtil.exchange(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 2};
        sort(arr);
        SortsUtil.print(arr);
    }
}
