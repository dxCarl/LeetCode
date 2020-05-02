package com.xiao.deng.jz_offer.question_09;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * <p>
 * 队列声明如下：
 * 请实现它的两个函数：
 * appendTail  deleteHead
 * 分别完成子队列点尾部插入节点 和 队列点头部删除节点点功能
 *
 * @param <T>
 */
public class CQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(T item) {
        stack1.push(item);
    }

    public T deleteHead() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                T data = stack1.peek();
                stack2.push(data);
                stack1.pop();

            }
        }
        T t = stack2.pop();
        return t;

    }

    public Stack<T> getStack1() {
        return stack1;
    }

    public void setStack1(Stack<T> stack1) {
        this.stack1 = stack1;
    }

    public Stack<T> getStack2() {
        return stack2;
    }

    public void setStack2(Stack<T> stack2) {
        this.stack2 = stack2;
    }

    public static void main(String[] args) {
        CQueue<Integer> cQueue = new CQueue<>();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        Integer ans = cQueue.deleteHead();
        System.out.println(ans);

    }
}
