package demo.annotation.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/4 02:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.PACKAGE, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD,
        ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
public @interface AnyAnnotation {

    int order() default 0;

    String desc() default "";

}
