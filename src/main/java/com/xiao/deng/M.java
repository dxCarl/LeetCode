package com.xiao.deng;

import com.alibaba.fastjson.JSONObject;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiao
 * @date 2020/10/21
 */
public class M {
    private  static volatile boolean flag = true;
    public static void main(String[] args) {

//        new Thread(()->{
//            while (flag) {
//                System.out.println(Thread.currentThread().getName() + "_" + System.currentTimeMillis());
//            }
//        },"t1").start();
//
//        new Thread(()->{
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "_" + System.currentTimeMillis());
//            flag = false;
//
//        }, "t2").start();

        long startTime = 60 * 30 * 24;
        Date date = new Date(startTime);
        DateFormat format = new SimpleDateFormat("yyyyMM");
        String yearMonth = format.format(startTime);
        String yearStr = yearMonth.substring(0, 4);
        String monthStr = yearMonth.substring(4);

        String list = "";

        List<Long> collect = Stream.of(list.split(",")).map(String::trim).map(Long::valueOf).collect(Collectors.toList());
        System.out.println(collect.size());
    }


}
