package com.xiao.deng;

class Person {
    private String name;
    private int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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

    public Student(int age, String name, String sid) {
        super(age, name);
        this.sid = sid;
    }

    public void run() {
        System.out.println("run()...");
    }

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
        s.study(5, 6);
        Student.getCnt();
        s.run();
    }
}

