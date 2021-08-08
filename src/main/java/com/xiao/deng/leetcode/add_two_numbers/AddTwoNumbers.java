package com.xiao.deng.leetcode.add_two_numbers;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public List<Integer> addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        int up = 0;
        fillNextNode(l1, l2, up, list);
        return list;
    }

    public void fillNextNode(ListNode l1, ListNode l2, int up, List<Integer> list) {
        if (l1 != null || l2 != null || up != 0) {
            int val1 = null != l1 ? l1.val : 0;
            int val2 = null != l2 ? l2.val : 0;
            list.add((val1 + val2 + up) % 10);
            up = (val1 + val2 + up) / 10;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
            fillNextNode(l1, l2, up, list);
        } else {
            return;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 2;
        ListNode l2 = new ListNode();
        l2.val = 5;
        ListNode l3 = new ListNode();
        l3.val = 4;
        ListNode l4 = new ListNode();
        l4.val = 6;
        ListNode l5 = new ListNode();
        l5.val = 3;
        ListNode l6 = new ListNode();
        l6.val = 4;

        l1.next = l3;
//        l3.next = l5;

        l2.next = l4;
        l4.next = l6;

        List<Integer> list = new AddTwoNumbers().addTwoNumbers(l1, l2);
        list.stream().forEach(System.out::println);

    }
}
