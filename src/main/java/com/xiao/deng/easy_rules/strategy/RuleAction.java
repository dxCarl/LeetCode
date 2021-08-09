package com.xiao.deng.easy_rules.strategy;

/**
 * @author xiao
 */
public interface RuleAction<T,R> {

    /**
     * action 执行返回
     * @return
     */
    R getData();


    /**
     * action 具体执行
     */
    void execute(T t);

}
