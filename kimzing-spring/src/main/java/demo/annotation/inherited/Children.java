package demo.annotation.inherited;

import java.lang.annotation.Annotation;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/3 00:30
 */
public class Children extends Parent {

    public static void main(String[] args) {
        Class<Children> childrenClass = Children.class;
        Annotation[] annotations = childrenClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}
