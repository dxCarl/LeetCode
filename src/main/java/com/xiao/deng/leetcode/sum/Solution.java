package com.xiao.deng.leetcode.sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] addition = new int[]{};
        int idx = 0;
        addition[idx] = 0;
        ListNode start;
        ListNode next =null;
        ListNode n1;
        ListNode n2;
        while (null != l1.next) {
            while (null != l2.next) {
                n1 = l1.next;
                n2 = l2.next;
                int val = (n1.val + n2.val) % 10 + addition[idx++];
                int ad = (n1.val + n2.val) / 10;
                addition[idx] = ad;
                start = new ListNode(val);
                start.next = next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 26;
        int[] ans = new Solution().twoSum(nums, target);
        System.out.println(ans);
    }
}
