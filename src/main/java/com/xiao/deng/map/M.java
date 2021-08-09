package com.xiao.deng.map;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@Slf4j
public class M {
    public static void main(String[] args) {
//        new M().B();
        TraceMessage message = new TraceMessage();
        Integer integer = Optional.ofNullable(message)
                .map(TraceMessage::getType)
                .filter(Objects::nonNull)
                .orElse(null);
        System.out.println("" + integer);
    }

    public void A() {
        System.out.printf("a...");

        StackTraceElement elements[] = Thread.currentThread().getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            StackTraceElement stackTraceElement=elements[i];
            String className=stackTraceElement.getClassName();
            String methodName=stackTraceElement.getMethodName();
            String fileName=stackTraceElement.getFileName();
            int lineNumber=stackTraceElement.getLineNumber();
            System.out.println("StackTraceElement数组下标 i="+i+",fileName="
                    +fileName+",className="+className+",methodName="+methodName+",lineNumber="+lineNumber);

        }
    }

    public void B(){
        System.out.printf("b...");
        A();
    }
}
