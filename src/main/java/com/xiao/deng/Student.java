package com.xiao.deng;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void run() {
    }
}

interface IStudyable {
    public int study(int a, int b);
}

public class Student extends Person implements IStudyable {
    private static int cnt = 5;

    static {
        cnt++;
    }

    private String sid;

    public static void setCnt(int cnt) {
        Student.cnt = cnt;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Student(int age, String name, String sid) {
        super(age, name);
        this.sid = sid;
    }


    @Override
    public void run() {
        System.out.println("run()...");
    }

    @Override
    public int study(int a, int b) {
        int c = 10;
        int d = 20;
        return a + b * c - d;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void main(String[] args) {
        Student s = new Student(23, "dqrcsc", "20150723");
        Student s2 = new Student(24, "dqrcsc", "20150723");
        Student s3 = new Student(23, "dd", "df");
        List<Student> students = new ArrayList<>();
        students.add(s2);
        students.add(s3);
        students.add(s);
//        s.study(5, 6);
//        Student.getCnt();
//        s.run();
        List<Student> collect = students.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        System.out.println(collect.size());

        Class clazz = String.class;
        System.out.println(clazz.equals(String.class));
    }
}

