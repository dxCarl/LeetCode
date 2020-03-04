package com.xiao.deng.leetcode.reverse;

import java.util.Stack;

public class ListReverse {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur!= null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode p;
        ListNode c;
        ListNode first;
        ListNode last = head;
        while (null != head) {
            nodeStack.push(head);
            head = head.next;
        }
        int size = nodeStack.size();
        if (size >= 1) {
            first = nodeStack.peek();
            while (nodeStack.size() > 1) {
                p = nodeStack.pop();
                c = nodeStack.peek();
                p.next = c;
                last = c;
            }
            last.next = null;
            return first;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode reverse = new ListReverse().reverseList(node);
//        ListNode reverse = new ListReverse().reverseList2(node);
        System.out.printf(reverse.toString());

    }
}
