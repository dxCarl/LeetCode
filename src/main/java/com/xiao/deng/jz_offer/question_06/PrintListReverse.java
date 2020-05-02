package com.xiao.deng.jz_offer.question_06;

import java.util.Stack;

public class PrintListReverse {
    public void printListReverse(ListNode node) {
        if (node != null) {
            if (node.getNext() != null) {
                ListNode next = node.getNext();
                printListReverse(next);
            } else {
                System.out.println(node.toString());
            }
        }

    }

    public void printListReverseStack(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.getNext();
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
