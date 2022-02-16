package com.xiao.deng.proxy.cglib_proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiao
 */
public class MethodInterceptorImpl implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy before say hello...");
        final Object returnVal = methodProxy.invokeSuper(o, args);
        System.out.println("cglib proxy after say hello...");
        return returnVal;
    }
}
