package com.xiao.deng.easy_rules.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiao
 */
public class TagRuleAction implements RuleAction<Map<String, String>, Map<String, String>> {
    private Map<String, String> tagMap = new HashMap<>();
    @Override
    public Map<String, String> getData() {
        return tagMap;
    }

    @Override
    public void execute(Map<String, String> tags) {

    }
}
