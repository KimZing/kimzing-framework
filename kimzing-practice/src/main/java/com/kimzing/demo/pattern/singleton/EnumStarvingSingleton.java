package com.kimzing.demo.pattern.singleton;

/**
 * 使用枚举进行饿汉单例.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/9 23:21
 */
public enum  EnumStarvingSingleton {
    INSTANCE;

    public void sayMyName() {
        System.out.println(this.name());
    }

}
