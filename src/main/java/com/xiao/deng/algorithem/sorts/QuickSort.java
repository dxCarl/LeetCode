package com.xiao.deng.algorithem.sorts;

/**
 * @author xiao
 * @date 2020/03/29
 * <p>
 * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
 * 其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * <p>
 * 算法描述:
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * <p>
 * 时间复杂度（平均）： O(n * log2n)
 * 时间复杂度（最坏）： O(n^2)
 * 时间复杂度（最好）： O(n * log2n)
 * 空间复杂度： O(n * log2n)
 * 稳定性：不稳定
 */
public class QuickSort implements SortAlgorithm {
    /**
     * sort
     *
     * @param unsorted
     * @return
     */
    @Override
    public int[] sort(int[] unsorted) {
        quickSort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    private void quickSort(int[] arr, int i, int j) {
        if (i < j) {
            int left = i;
            int right = j;
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        int idx = left;
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && arr[j] > tmp) {
                j--;
            }
            arr[idx] = arr[j];
            idx = j;

            while (i < j && arr[i] < tmp) {
                i++;
            }
            arr[idx] = arr[i];
            idx = i;
        }
        arr[idx] = tmp;

        return idx;
    }

    public static void main(String[] args) {
        new QuickSort().sortTest();
    }
}
