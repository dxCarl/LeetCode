package com.xiao.deng.algorithem.sorts;

import java.util.List;

/**
 * @author xiao
 */
public class  SortsUtil {
   public static void print(List<?> toPrint) {
        toPrint.stream()
                .map(Object::toString)
                .map(str -> str + " ")
                .forEach(System.out::print);

        System.out.println();
    }

    public static void print(int[] arr) {
        if (arr.length > 0) {
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }

    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
