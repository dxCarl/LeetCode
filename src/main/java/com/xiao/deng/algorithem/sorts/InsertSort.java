package com.xiao.deng.algorithem.sorts;

/**
 * @author xiao
 * @date 2020/03/28
 * <p>
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * <p>
 * 算法描述：
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 *
 * <p>
 * 时间复杂度（平均）： O(n^2)
 * 时间复杂度（最坏）： O(n^2)
 * 时间复杂度（最好）： O(n)
 * 空间复杂度： O(1)
 * 稳定性：稳定
 */
public class InsertSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] arr) {
        int len = arr.length;
        int preIdx;
        for (int i = 1; i < len; i++) {
            preIdx = i - 1;
            int cur = arr[i];
            while (preIdx >= 0 && cur < arr[preIdx]) {
                arr[preIdx + 1] = arr[preIdx];
                preIdx--;
            }
            arr[preIdx + 1] = cur;
        }

        return arr;
    }

    public static void main(String[] args) {
        new InsertSort().sortTest();

    }
}
