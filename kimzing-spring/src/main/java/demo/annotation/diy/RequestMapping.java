package demo.annotation.diy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/4 01:55
 */
// 保留至运行时
@Retention(RetentionPolicy.RUNTIME)
// 可以加在方法或者类上
@Target(value = {ElementType.TYPE,ElementType.METHOD})
public @interface RequestMapping {

    public String method() default "GET";

    public String path();

    public boolean required();

}
