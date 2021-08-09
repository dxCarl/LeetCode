package com.xiao.deng.aviator;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;

/**
 * @author xiao
 */
public class MyRuleListener implements RuleListener {

    @Override
    public boolean beforeEvaluate(Rule rule, Facts facts) {
        facts.put("jobId", 5);
        return true;
    }
}
