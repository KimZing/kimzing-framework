package demo.annotation.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解底层学习.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/5 19:21
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Learn {
    String name() default "default";
    int age();
}
