package com.xiao.deng.algorithem.sorts;

/**
 * @author xiao
 * <p>
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * <p>
 * <B>算法描述</B>
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * 初始状态：无序区为R[1..n]，有序区为空；
 * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
 * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
 * 将它与无序区的第1个记录R交换，
 * 使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * n-1趟结束，数组有序化了。
 * <p>
 * 时间复杂度（平均）： O(n^2)
 * 时间复杂度（最坏）： O(n^2)
 * 时间复杂度（最好）： O(n^2)
 * 空间复杂度： O(1)
 * 稳定性：不稳定
 */
public class SelectionSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    idx = j;
                    min = arr[j];
                }
            }
            if (idx > i) {
                SortsUtil.exchange(arr, i, idx);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        new SelectionSort().sortTest();
    }
}
