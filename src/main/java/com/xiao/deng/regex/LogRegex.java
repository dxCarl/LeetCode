package com.xiao.deng.regex;

import com.xiao.deng.TestEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRegex {
    public static void main(String[] args) {
        System.out.println("main()获取到的参数是："+args[0]);
        String log = "Archer Log: log finish, executor node: 10.71.188.39, end time: 2021-04-25 16:54:14, end status: TEST_1";
        final String ARCHER_LOG_FINISH_STATUS_TAG = "end status:";
        String statusRegx = ARCHER_LOG_FINISH_STATUS_TAG + " (\\S+)";
        Pattern p = Pattern.compile(statusRegx);
        Matcher matcher = p.matcher(log);
        if (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
            TestEnum testEnum = TestEnum.valueOf(group);
            System.out.println(testEnum);
        }
    }
}
