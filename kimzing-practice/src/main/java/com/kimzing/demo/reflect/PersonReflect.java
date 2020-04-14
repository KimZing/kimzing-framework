package com.kimzing.demo.reflect;

import java.time.LocalDateTime;

/**
 * 反射的目标.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/31 10:27
 */
public class PersonReflect {

    public String name;

    protected Integer age;

    Double amount;

    public static String hello = "HELLO";

    private LocalDateTime birth;

    public PersonReflect() {
    }

    public PersonReflect(String str) {
        System.out.println("公开构造函数:" + str);
    }

    PersonReflect(int i) {
        System.out.println("默认构造函数" + i);
    }

    protected PersonReflect(String str, int i) {
        System.out.println("受保护的构造函数" + str + i);
    }

    private PersonReflect(char ch) {
        System.out.println("私有构造函数" + ch);
    }

    public void method1() {
        System.out.println("public method");
    }

    void method2(String str) {
        System.out.println("public method" + str);
    }

    protected void method3() {
        System.out.println("protected method");
    }

    private void method4(Integer integer) {
        System.out.println("private method" + integer);
    }

    public static void hello() {
        System.out.println("Hello");
    }

}
