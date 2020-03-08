package com.xiao.deng.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxQueue {
    Queue<Integer> que;
    Deque<Integer> deq;

    public MaxQueue() {
        que = new LinkedList<>();  //队列：插入和删除
        deq = new LinkedList<>();  //双端队列：获取最大值
    }

    public int max_value() {
        return deq.size()>0?deq.peek():-1;  //双端队列的队首为que的最大值
    }

    public void push_back(int value) {
        que.offer(value);  //value入队
        while(deq.size()>0 && deq.peekLast()<value){
            deq.pollLast();  //将deq队尾小于value的元素删掉
        }
        deq.offerLast(value);  //将value放在deq队尾
    }

    public int pop_front() {
        int tmp = que.size()>0?que.poll():-1;  //获得队首元素
        if(deq.size()>0 && tmp==deq.peek()){
            deq.poll();  //如果出队的元素是当前最大值，将deq的队首出队
        }
        return tmp;
    }

}
