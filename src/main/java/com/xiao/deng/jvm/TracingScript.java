//package com.xiao.deng.jvm;
//
///**
// * @author xiao
// * @date 2020/10/24
// */
///* BTrace Script Template */
//import com.sun.btrace.annotations.*;
//import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TracingScript {
//    /* put your code here */
//    @OnMethod(clazz = "com.xiao.deng.jvm.BTraceTest", method = "add", location = @Location(Kind.RETURN))
//    public static void func(@Self com.xiao.deng.jvm.BTraceTest instance, int a, int b, @Return int result) {
//        println("调用堆栈：");
//        jstack();
//        println(strcat("方法参数A：", str(a)));
//        println(strcat("方法参数B：", str(b)));
//        println(strcat("方法结果：", str(result)));
//    }
//}
