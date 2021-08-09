package com.xiao.deng.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.jeasy.rules.api.*;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Test {
    private static Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        // define facts
        Facts facts = new Facts();
        facts.put("rain", true);
        facts.put("id", 2);
        facts.put("a", 100);
        facts.put("b", 45);
        facts.put("c", -199);
        facts.put("d", 2);
        facts.put("jobId", 15);
        facts.put("departmentId", 1);

        String expression = "jobId < 10 && departmentId == 1";
        String expression2 = "jobId < 6";

        // define rules
        Rule weatherRule = new RuleBuilder()
                .name("weather rule")
                .priority(1)
                .description("if it rains then take an umbrella")
                .when(f -> aviatorCompute(facts, expression))
                .then(f -> System.out.println("It rains, take an umbrella!"))
                .build();

        Rule rule2 = new RuleBuilder()
                .name("second rule")
                .priority(-1)
                .description("if it rains then take an umbrella")
                .when(f -> aviatorCompute(facts, expression2))
                .then(f -> System.out.println("ex 2"))
                .build();

        Rules rules = new Rules();
        rules.register(weatherRule, rule2);

        RulesEngineParameters parameters = new RulesEngineParameters()
//                .priorityThreshold(10)
//                .skipOnFirstAppliedRule(true)
//                .skipOnFirstFailedRule(true)
//                .skipOnFirstNonTriggeredRule(true)
                ;

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);


        ((DefaultRulesEngine) rulesEngine).registerRuleListener(new MyRuleListener());
        rulesEngine.fire(rules, facts);

    }

    public static boolean aviatorCompute(Facts facts, String expression) {
        Map<String, Object> env = facts.asMap();
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Boolean result = (Boolean) compiledExp.execute(env);
        log.info("execute expression : {} {}", expression, result);
        return result;
    }

}
