package com.xiao.deng.leetcode.add_two_numbers;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode node = new ListNode();
        ListNode cur = node;
        fillNextNode(l1, l2, up, cur);
        return node;
    }

    public void fillNextNode(ListNode l1, ListNode l2, int up, ListNode cur) {
        if (l1 != null || l2 != null || up != 0) {

            int val1 = null != l1 ? l1.val : 0;
            int val2 = null != l2 ? l2.val : 0;
            cur.val = (val1 + val2 + up) % 10;
            up = (val1 + val2 + up) / 10;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
            if (l1 == null && l2 == null && up == 0) {
                return;
            } else {
                ListNode next = new ListNode();
                cur.next = next;
                cur = cur.next;
                fillNextNode(l1, l2, up, cur);
            }
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
        l3.next = l5;

        l2.next = l4;
        l4.next = l6;

        ListNode node = new Solution().addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
}
