package com.kimzing.demo.reflect.demo;

import com.kimzing.demo.reflect.PersonReflect;

/**
 * 获取Class对象的三种方式.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/31 11:28
 */
public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        // 通过实例获取,需要导入对应包并创建实例
        PersonReflect personReflect = new PersonReflect();
        Class<? extends PersonReflect> clazz1 = personReflect.getClass();
        // 通过类获取，需要导入对应包
        Class<PersonReflect> clazz2 = PersonReflect.class;
        // 通过全路径获取，最灵活的方式，无需任何依赖，只需要传入包路径+类名即可
        Class<?> clazz3 = Class.forName("com.kimzing.demo.reflect.PersonReflect");

        // 结果为true，代表获取的Class对象都是同一个实例
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
    }

}
