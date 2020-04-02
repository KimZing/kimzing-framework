package demo.annotation.retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/2 23:54
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation2 {
}
