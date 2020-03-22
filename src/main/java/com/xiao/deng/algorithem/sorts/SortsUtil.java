package com.xiao.deng.algorithem.sorts;

import java.util.List;

public class SortsUtil {
    static void print(List<?> toPrint) {
        toPrint.stream()
                .map(Object::toString)
                .map(str -> str + " ")
                .forEach(System.out::print);

        System.out.println();
    }
}
