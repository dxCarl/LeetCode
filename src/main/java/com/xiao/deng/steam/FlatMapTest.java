package com.xiao.deng.steam;

import com.xiao.deng.Student;
import com.xiao.deng.TestEnum;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xiao
 */
public class FlatMapTest {
    public static void main(String[] args) {
        List<String> first = Arrays.asList("one", "two", "three", "four");
        List<String> second = Arrays.asList("A", "B", "C", "D");
        Stream.of(first, second)
                .flatMap(Collection::stream)
                .filter(item -> !item.equals("A"))
                .forEach(System.out::println);
        Student student = null;

        String s = Optional.ofNullable(student).map(Student::getSid).orElse("");
        System.out.println(s);

        System.out.println(TestEnum.TEST_1.name());
    }
}
