package com.xiao.deng.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -XX:MaxMetaspceSize=10M
 * @author xiao
 * @date 2020/10/08
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
