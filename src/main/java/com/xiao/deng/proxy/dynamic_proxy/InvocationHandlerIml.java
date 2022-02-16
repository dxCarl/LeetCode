package com.xiao.deng.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xiao
 */
public class InvocationHandlerIml implements InvocationHandler {
    private Object object;

    public InvocationHandlerIml(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Dynamic proxy Before say hello...");
        Object returnValue = method.invoke(object, args);
        System.out.println("Dynamic proxy After say hello...");
        return returnValue;
    }
}
