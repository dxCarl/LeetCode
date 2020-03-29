package com.xiao.deng.algorithem.sorts;

/**
 * @author xiao
 * <p>
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * <p>
 * 算法描述
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * <p>
 * 时间复杂度（平均）： O(n^1.3)
 * 时间复杂度（最坏）： O(n^2)
 * 时间复杂度（最好）： O(n)
 * 空间复杂度： O(1)
 * 稳定性：不稳定
 */
public class ShellSort implements SortAlgorithm {

    /**
     * sort
     *
     * @param unsorted
     * @return
     */
    @Override
    public int[] sort(int[] unsorted) {
        //增量gap，并逐步缩小增量
        for (int gap = unsorted.length >> 1; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < unsorted.length; i++) {
                int j = i;
                while (j - gap >= 0 && unsorted[j] < unsorted[j - gap]) {
                    //插入排序采用交换法
                    SortsUtil.exchange(unsorted, j, j - gap);
                    j -= gap;
                }
            }
        }
        return unsorted;
    }

    public static void main(String[] args) {
        new ShellSort().sortTest();
    }

}
