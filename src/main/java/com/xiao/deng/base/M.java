package com.xiao.deng.base;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiao
 * @date 2020/09/11
 */
public class M {
    public static void main(String[] args) {
        LockUtil util = LockUtil.getInstance();
        List<Long> list1 = Arrays.asList(new Long[]{1L, 2L,3L,4L,5L,6L,7L, 8L,9L,10L});
        List<Long> list2 = Arrays.asList(new Long[]{6L,7L, 8L,9L,10L,11L,12L,13L,14L,15L});

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeIf(item -> item > 2);

        List[] lists = {list1};
        StringUtils.join(lists, ",");
//        Thread t1 = new Thread(new A(util, list1), "a");
//        Thread t2 = new Thread(new B(util, list2), "b");
//        t1.start();
//        t2.start();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("fineshed, thread name : " + Thread.currentThread().getName());

//        long w = 5L;
//        long m = -1L ^ (-1L << w);
//        System.out.println( m);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(3);
        objectObjectHashMap.put(1, 1);
        System.out.println(objectObjectHashMap.isEmpty());

        if (list1.size() > 1) {
            System.out.println(1);
        } else if (list1.size() > 2) {
            System.out.println(2);
        }
    }
}
