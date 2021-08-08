//package com.xiao.deng.ast;
//
//import com.alibaba.druid.sql.SQLUtils;
//import com.alibaba.druid.util.JdbcConstants;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author xiao
// * @date 2020/07/23
// */
//public class Refactor {
//    public static void main(String[] args) {
//        Map<String, String> mapping = new HashMap<>();
//        mapping.put("tb", "table1");
//        mapping.put("test", "table2");
//
////        String sql = "select * from user";
//        String sql = "SELECT s1.tb.id, s1.tb.date, s2.test.f1, s2.test.f2 FROM s1.tb JOIN s2.test on s1.tb.id = s2.test.f1";
//        String result = SQLUtils.refactor(sql, JdbcConstants.PRESTO, mapping);
//        System.out.println(result);
//
//    }
//}
