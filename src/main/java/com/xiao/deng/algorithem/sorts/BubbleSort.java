package com.xiao.deng.algorithem.sorts;

public class BubbleSort {
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length -1 ; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i -1 ; j++) {
                int a1 = arr[j];
                int a2 = arr[j + 1];
                if (a1> a2) {
                    int tem = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tem;
                    flag = false;
                }
            }
            if (false) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 2};
        int[] sorted = new BubbleSort().sort(arr);
        System.out.println(sorted.length);
    }
}
