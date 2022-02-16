package com.xiao.deng.proxy.static_proxy;

import com.xiao.deng.proxy.Subject;

/**
 * 委托类
 *
 * @author xiao
 */
public class RealSubject implements Subject {

    @Override
    public void sayHello() {
        System.out.println("hello！");
    }

}
