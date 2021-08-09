package com.xiao.deng.regex;

import com.alibaba.fastjson.annotation.JSONType;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

@JSONType
public class RegexTest {
//    public static void main(String[] args) {
//        Pattern pattern = compile("(?=tmp)[\\w]+");
//        Matcher abc_tmp_xxx = pattern.matcher("tmpxx123_x");
//        boolean matches = abc_tmp_xxx.matches();
//        System.out.println(matches);
//        Annotation[] annotations = RegexTest.class.getAnnotations();
//        String name = annotations[0].getClass().getName();
//        System.out.println(name);
//        String username = "zhengzhisheng";
//
//        String s = "(" + username +  ")" +"(@bilibili.co)?,?";
//        Pattern p = compile(s);
//        String r = "zhengzhisheng@bilibili.com,zhengzhisheng";
//        Matcher m = p.matcher(r);
//        if (m.find()) {
//            int c = m.groupCount();
//            for (int i = 0; i < c; i++) {
//                System.out.println(m.group(i));
//            }
//            String replaceAll = m.replaceAll("dengxiao");
//            System.out.println(replaceAll);
//        }
//
//    }

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("myTable", "aaa");
        params.put("username", "zhangsan");
        params.put("Title", "hehe");

        String str = "${myTable}===数据测试=====${username}====数据测试=====${Title}";
        Pattern pattern = compile("\\$\\{(.+?)\\}",
                CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(str);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String keyText = matcher.group(1);
            matcher.appendReplacement(result, params.get(keyText));
        }
        System.out.println(result);


        String username = "zhengzhisheng";

        String s = "(" + username + ")" + "(@bilibili.co)?,?";
        String s1 = "(zhengzhisheng)(@bilibili.com)?,?";
        String s2 = "(zhengzhisheng)(@bilibili.com)?,?";
        String s3 = "(zhengzhisheng)(@bilibili.com)?,?";
        String s4 = "(zhengzhisheng)(@bilibili.com)?,?";
        Pattern p = compile(s);
        String r = "zhengzhisheng@bilibili.com,zhengzhisheng,aa,zhengzhisheng01,aa@bilibili.com,zhengzhisheng01";

        String[] split = r.split(",");

        StringBuffer sb = new StringBuffer();
        Matcher m = p.matcher(r);
        Map<String, String> map = new HashMap<>();
        map.put("zhengzhisheng@bilibili.com,", "dengxiao@bilibili.com,");
        map.put("zhengzhisheng", "dengxiao");
        map.put("zhengzhisheng,", "dengxiao,");
        map.put("zhengzhisheng@bilibili.com", "dengxiao@bilibili.com");

//        while (m.find()) {
//            String key = m.group(1);
//            System.out.println("key: " + key);
//            String replace = m.group();
//            System.out.println("replace: " + replace);
//            String s0 = map.get(replace);
//            System.out.println("s1: " + s0);
//            m.appendReplacement(sb, s0);
//        }
//        m.appendTail(sb);
//        System.out.println(sb.toString());
       String newName = "dengxiao";
        String oldName = "zhengzhisheng";
        String[] replaced = new String[split.length];
        for (int i = 0; i  < split.length; i++) {
            String mail = split[i];
            if (mail.equals("zhengzhisheng") || mail.equals("zhengzhisheng@bilibili.com")) {
                String newStr = mail.replace(oldName, newName);
                replaced[i] = newStr;
            }else {
                replaced[i] = mail;
            }
        }

        String join = String.join(",", replaced);
        System.out.println(join);
    }


}
