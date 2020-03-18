package com.xiao.deng.leetcode.sum;

public class ListNode {
    int val;
    ListNode next;

    public ListNode getNext() {
        return this.next;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val =val;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }
    public ListNode(int x) {
        val = x;
    }

    public ListNode(){}
}
