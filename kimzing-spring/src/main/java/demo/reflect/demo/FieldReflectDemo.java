package demo.reflect.demo;

import demo.reflect.PersonReflect;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 * 属性反射.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/31 13:07
 */
public class FieldReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> pClass = Class.forName("demo.reflect.PersonReflect");
        System.out.println("----获取公开的属性");
        Field[] fields = pClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("----获取所有的属性");
        fields = pClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("----获取单个公开的属性");
        Field name = pClass.getField("name");
        System.out.println(name);

        System.out.println("----获取非公开的属性");
        Field birth = pClass.getDeclaredField("birth");
        System.out.println(birth);

        System.out.println("----设置属性的值");
        PersonReflect personReflect = (PersonReflect) pClass.newInstance();
        System.out.println("--设置公开的属性");
        name.set(personReflect, "KimZing");
        System.out.println("name的值为" + personReflect.name);
        System.out.println("--设置非公开的属性,并读取非公开属性");
        birth.setAccessible(true);
        birth.set(personReflect, LocalDateTime.now());
        System.out.println("birth的值为" + birth.get(personReflect));

        System.out.println("----获取静态的属性");
        Field hello = pClass.getField("hello");
        System.out.println(hello.get(null));
    }

}
