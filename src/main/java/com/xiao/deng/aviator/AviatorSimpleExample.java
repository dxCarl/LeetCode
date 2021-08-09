package com.xiao.deng.aviator;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AviatorSimpleExample {
    public static void main(String[] args) {
//        String expression = "{1,2}.contains(d)";
        String expression = "jobId < 10 && departmentId == 1";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<>();
        env.put("a", 5);
        env.put("b", 45);
        env.put("c", -199);
        env.put("d", 2);
        env.put("jobId", 5);
        env.put("departmentId", 1);
        env.put("job_type", "1");
        Object result = compiledExp.execute(env);
        System.out.println(result);

        String exp1 = " (a < 10 || f  >0 ) ? b : c";
        String exp2 = "'1','2'";
        Integer re = (Integer) AviatorEvaluator.compile(exp1).execute(env);
        System.out.println(re);


//        Map<String, Object> env = new HashMap<String, Object>();
        ArrayList<String> list = new ArrayList<String>();
        list.add("3");
        list.add("20");
        list.add("10");
        env.put("list", list);
        env.put("email", "killme2008@gmail.com");
        env.put("date", new Date());
        String username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1 : 'unknow' ", env);
        System.out.println(username);
        System.out.println(AviatorEvaluator.exec("a>0? 'yes':'no'", 1));
//        System.out.println(AviatorEvaluator.execute("'test.aa ='+test.aa", env));
        System.out.println(AviatorEvaluator.execute(" obj==nil", env));
        System.out.println(AviatorEvaluator.execute(" date > '2018-05-21 00:00:00:00'", env));
        System.out.println(AviatorEvaluator.execute(" date > '2018-05-22 12:00:00:00'", env));

        result = AviatorEvaluator.execute("count(list)", env);
        System.out.println(result);  // 3
        result = AviatorEvaluator.execute("reduce(list,+,0)", env);
        System.out.println(result);  // 33
        result = AviatorEvaluator.execute("filter(list,seq.gt('9'))", env);
        System.out.println(result);  // [10, 20]
        result = AviatorEvaluator.execute("include(list,'10') && a > 1", env);
        System.out.println(result);  // true
        result = AviatorEvaluator.execute("sort(list)", env);
        System.out.println(result);  // [3, 10, 20]

        String exp = "(include(tags,'e1') || include(tags,'e3')) && host = 'e1'";
//        compiledExp = AviatorEvaluator.compile(exp, true);
//        compiledExp.execute(env);

        Object execute = AviatorEvaluator.execute("projectId == nil", env);

        Object aNull = valueWrapper("null", Long.class);
        System.out.printf((String) aNull);

    }

    private static Object valueWrapper(String value, Class clazz) {
        if (clazz.equals(String.class)) {
            return StringUtils.isNotBlank(value) ? "'" + value + "'" : StringUtils.EMPTY;
        }

        try {
            Object o = JSONObject.parseObject(value, clazz);
            return o;
        } catch (Exception e) {
            return StringUtils.isNotBlank(value) ? "'" + value + "'" : StringUtils.EMPTY;
        }
    }

}
