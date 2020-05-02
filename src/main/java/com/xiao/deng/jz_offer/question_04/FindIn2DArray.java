package com.xiao.deng.jz_offer.question_04;

/**
 * 二维数组中的查找
 * 在一个二维数组中， 每一行都按照从左到右点递顺序排序， 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样点一个二维数组和一个整数， 判断数组中是否包含该整数
 */
public class FindIn2DArray {
    public boolean find(int[][] arr, int num) {
        int m = arr.length;
        int n = arr[0].length;
        int i = 0;
        int j = n - 1;
        while (j >= 0 && i < m) {
            int cur = arr[i][j];
            if (num > cur) {
                i++;
            } else if (num == cur) {
                return true;
            } else {
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int num = 14;
        boolean exists = new FindIn2DArray().find(matrix, num);
        System.out.println(exists);
    }
}
