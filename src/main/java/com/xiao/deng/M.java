package com.xiao.deng;

import com.alibaba.fastjson.JSONObject;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    }


}
