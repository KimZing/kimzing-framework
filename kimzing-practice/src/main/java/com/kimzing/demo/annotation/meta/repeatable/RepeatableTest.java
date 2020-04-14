package com.kimzing.demo.annotation.meta.repeatable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/3 00:52
 */
public class RepeatableTest {

    @MyAnnotation(index = 1)
    @MyAnnotation(index = 2)
    public void test(){}

    public static void main(String[] args) throws NoSuchMethodException {
        Class<RepeatableTest> repeatableTestClass = RepeatableTest.class;
        Method test = repeatableTestClass.getMethod("test");
        Annotation[] annotations = test.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}
