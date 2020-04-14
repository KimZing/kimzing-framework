package com.kimzing.demo.annotation.meta.repeatable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/3 00:48
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotaions {

    MyAnnotation[] value();

}
