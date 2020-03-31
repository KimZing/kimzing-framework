package com.kimzing.demo.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 构造器反射.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/31 11:26
 */
public class ConstructorReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> pClass = Class.forName("com.kimzing.demo.reflect.PersonReflect");

        System.out.println("----获取所有的公有构造方法");
        Constructor<?>[] constructors = pClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("----获取所有的构造方法，包含protected default private");
        constructors = pClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("----获取单个公开的构造方法");
        Constructor<?> constructor = pClass.getConstructor(String.class);
        System.out.println(constructor);

        System.out.println("----获取私有的构造方法");
        constructor = pClass.getDeclaredConstructor(char.class);
        System.out.println(constructor);

        System.out.println("----使用反射得到的构造器创建实例");
        // 任何包均可直接获取
        System.out.println("--公开构造方法");
        constructor = pClass.getConstructor(String.class);
        constructor.newInstance("Hello");
        // protected/default/private 均需要设置权限，如果和反射操作类处于同一个包下则无需设置权限
        System.out.println("--受保护的构造方法");
        constructor = pClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Object hello = constructor.newInstance("hello", 18);
        System.out.println("--默认的构造方法");
        constructor = pClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        constructor.newInstance(24);
        System.out.println("--私有的构造方法");
        constructor = pClass.getDeclaredConstructor(char.class);
        constructor.setAccessible(true);
        constructor.newInstance('a');
    }

}
