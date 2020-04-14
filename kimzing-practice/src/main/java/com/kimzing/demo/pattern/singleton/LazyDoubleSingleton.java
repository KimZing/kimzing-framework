package com.kimzing.demo.pattern.singleton;

/**
 * 懒汉双重检查锁.无法防止反射
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/9 20:36
 */
public class LazyDoubleSingleton {

    private static volatile LazyDoubleSingleton lazyDoubleSingleton;

    private LazyDoubleSingleton() { }

    public static LazyDoubleSingleton getInstance() {
        if (lazyDoubleSingleton == null) {
            synchronized (LazyDoubleSingleton.class) {
                if (lazyDoubleSingleton == null) {
                    // memory = allocate() 1.分配内存
                    // instance(memory)  2.初始化对象
                    // instance = memory 3.设置instance只想刚分配的内存地址，此时instance != null
                    lazyDoubleSingleton = new LazyDoubleSingleton();
                }
            }
        }
        return lazyDoubleSingleton;
    }

}
