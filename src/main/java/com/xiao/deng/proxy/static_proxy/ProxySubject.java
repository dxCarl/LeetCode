package com.xiao.deng.proxy.static_proxy;

import com.xiao.deng.proxy.Subject;

/**
 * 代理类
 *
 * @author xiao
 */
public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void sayHello() {
        System.out.println("Before say hello...");
        subject.sayHello();
        System.out.println("After say hello...");
    }

}
