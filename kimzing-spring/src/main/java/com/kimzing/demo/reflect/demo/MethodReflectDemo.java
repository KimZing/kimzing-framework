package com.kimzing.demo.reflect.demo;

import com.kimzing.demo.reflect.PersonReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 方法反射.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/31 13:20
 */
public class MethodReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> pClass = Class.forName("com.kimzing.demo.reflect.PersonReflect");
        System.out.println("----获取公开方法，包含父类方法");
        Method[] methods = pClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("----获取所有方法,包含非公开的方法");
        methods = pClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("----获取单个的公开方法");
        Method method1 = pClass.getMethod("method1");
        System.out.println(method1);

        System.out.println("----获取单个的非公开的方法");
        Method method4 = pClass.getDeclaredMethod("method4", Integer.class);
        System.out.println(method4);

        System.out.println("----执行公开方法");
        PersonReflect personReflect = (PersonReflect) pClass.newInstance();
        method1.invoke(personReflect);

        System.out.println("----执行非公开方法");
        method4.setAccessible(true);
        method4.invoke(personReflect, 12);

        System.out.println("----执行静态方法");
        Method hello = pClass.getMethod("hello");
        hello.invoke(null);
    }

}
