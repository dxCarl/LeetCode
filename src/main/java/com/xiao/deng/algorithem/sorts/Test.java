package com.xiao.deng.algorithem.sorts;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        Iterator iterator = list.iterator();

        LinkedList linkedList = new LinkedList();
        linkedList.peek();
        HashSet hashSet = new HashSet();
        LinkedHashSet linkedHashSet = new LinkedHashSet<>();
        TreeSet treeSet = new TreeSet((Comparator<Integer>) (o1, o2) -> o1 - o2);

        Hashtable table = new Hashtable();
        table.put(1, 1);
        ConcurrentHashMap cu = new ConcurrentHashMap<>();
        cu.put(null, null);


    }

    public int get(Integer a) {
        try {
            return a;
        } finally {
            return 2;
        }
    }
}
