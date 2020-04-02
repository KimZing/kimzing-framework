package demo.annotation.repeatable;

import java.lang.annotation.*;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/3 00:47
 */
@Repeatable(MyAnnotaions.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int index() default 0;
}
