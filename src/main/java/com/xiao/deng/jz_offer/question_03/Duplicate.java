package com.xiao.deng.jz_offer.question_03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复点数字
 */
public class Duplicate {
    private Set<Integer> findDuplicate(int[] inputs) {
        Boolean[] arr = new Boolean[inputs.length];
        Set<Integer> ans = new HashSet<>();
        Arrays.fill(arr, false);
        for (int i : inputs) {
            if (!arr[i]) {
                arr[i] = true;
            } else {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{2, 3, 1, 0, 2, 5, 3};
        Set<Integer> ans = new Duplicate().findDuplicate(inputs);
        if (ans.size() > 0) {
            for (Integer integer : ans) {
                System.out.println(integer);
            }
        }
    }

}
