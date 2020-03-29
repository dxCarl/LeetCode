package com.xiao.deng.algorithem.sorts;

/**
 * @author xiao
 * @date 2020/03/28
 */
public interface SortAlgorithm {
    /**
     * sort
     *
     * @param unsorted
     * @return
     */
    int[] sort(int[] unsorted);

    /**
     * sort test
     */
    default void sortTest() {
        int[] arr = new int[]{4, 3, 38, 5};
        arr = sort(arr);
        SortsUtil.print(arr);

    }
}
