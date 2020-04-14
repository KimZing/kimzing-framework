package com.kimzing.demo.annotation.runtime;

/**
 * 注解Demo.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/5 19:24
 */
@Learn(age = 12)
public class LearnAnnotationReflect {

    public static void main(String[] args) {
        Class<LearnAnnotationReflect> clazz = LearnAnnotationReflect.class;
        if (!clazz.isAnnotationPresent(Learn.class)) {
            return;
        }
        Learn learn = clazz.getAnnotation(Learn.class);
        System.out.println(learn.name());
        System.out.println(learn.age());
    }
}
