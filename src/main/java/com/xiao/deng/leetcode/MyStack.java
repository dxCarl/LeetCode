package com.xiao.deng.leetcode;

import java.util.ArrayList;
import java.util.List;

class MyStack {
    private List<Integer> myList ;
    private int topIdx;
    /** Initialize your data structure here. */
    public MyStack() {
        myList = new ArrayList<>();
        topIdx = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        topIdx ++;
        myList.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int out =  myList.get(topIdx);
        myList.remove(topIdx--);
        return  out;

    }

    /** Get the top element. */
    public int top() {
      return myList.get(topIdx);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return topIdx == -1;
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}
