package com.kimzing.demo.annotation.meta.inherited;

import java.lang.annotation.*;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/3 00:29
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyAnnotation {
}
