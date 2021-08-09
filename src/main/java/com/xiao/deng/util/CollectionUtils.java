package com.xiao.deng.util;

import java.util.*;

/**
 * @author xiao
 */
public class CollectionUtils {

    public static <T,K extends Collection<? extends T>> List<T> intersection(Collection<K> datas){
        List<T> result = new ArrayList<>();
        Iterator<K> it = datas.iterator();
        if(it.hasNext()){
            K copy = it.next();
            if(copy!=null){
                result = new ArrayList<>(copy);
                for (K k : datas) {
                    result.retainAll(k);
                }
            }
        }
        return result;
    }

    public static <T,K extends Collection<? extends T>> List<T> intersection(K...datas){
        return intersection(Arrays.asList(datas));
    }

    public static void main(String[] args) {
        List<List> lists = new ArrayList<>();
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        lists.add(list1);

        List list2 = new ArrayList();
//        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        lists.add(list2);

        List<Object> intersection = intersection(lists);
        System.out.println(intersection.size());

    }
}
