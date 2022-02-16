package com.xiao.deng.proxy;

import com.xiao.deng.proxy.cglib_proxy.MethodInterceptorImpl;
import com.xiao.deng.proxy.dynamic_proxy.InvocationHandlerIml;
import com.xiao.deng.proxy.static_proxy.ProxySubject;
import com.xiao.deng.proxy.static_proxy.RealSubject;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * 代理测试
 *
 * @author xiao
 */
public class ProxyTest {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.sayHello();

        InvocationHandlerIml handlerIml = new InvocationHandlerIml(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        final Class<?>[] interfaces = realSubject.getClass().getInterfaces();
        final Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handlerIml);
        subject.sayHello();

        final RealSubject proxy = (RealSubject) Enhancer.create(realSubject.getClass(), new MethodInterceptorImpl());
        proxy.sayHello();


    }
}
