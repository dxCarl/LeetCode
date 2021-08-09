package com.xiao.deng.easy_rules.strategy;

import org.jeasy.rules.api.Facts;

/**
 * @author xiao
 */
public interface RuleCondition {

    /**
     * condition 计算类别
     * @return
     */
    String getConditionType();

    /**
     *  计算条件
     * @param facts
     * @param expression
     * @return
     */
    boolean calculate(Facts facts, String expression);


}
