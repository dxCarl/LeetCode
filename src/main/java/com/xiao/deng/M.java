package com.xiao.deng;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiao
 * @date 2020/10/21
 */
@Slf4j
public class M {
    private static volatile boolean flag = true;

    public static void main(String[] args) {


        Map<Long, Integer> map = new HashMap<>();
        Integer orDefault = map.getOrDefault(1, 10);
        System.out.printf(String.valueOf(orDefault));

    }


}
