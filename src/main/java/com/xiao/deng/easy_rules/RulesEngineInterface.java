package com.xiao.deng.easy_rules;

/**
 * @author xiao
 */
public interface RulesEngineInterface<T> {
    /**
     * engine 类别
     *
     * @return
     */
    String getType();


    /**
     * 获取返回数据
     *
     * @return
     */
    T getData();

}
