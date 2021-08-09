package com.xiao.deng.easy_rules.strategy;

/**
 * @author xiao
 */
public interface RuleConf<T, R> {

    RuleAction<T, R> getRuleAction();

    RuleCondition getRuleCondition();

    void setRuleAction(RuleAction<T, R> action);

    void setRuleCondition(RuleCondition condition);

    int getPriority();
}
