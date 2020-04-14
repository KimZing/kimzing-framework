package com.kimzing.framework.core;

import com.kimzing.framework.core.annotation.Component;
import com.kimzing.framework.core.annotation.Controller;
import com.kimzing.framework.core.annotation.Repository;
import com.kimzing.framework.core.annotation.Service;
import com.kimzing.framework.util.ClassUtil;
import com.kimzing.framework.util.ValidationUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Bean容器.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/9 23:24
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanContainer {

    /**
     * 所有被标记的类及其实例
     */
    private static final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 当前框架支持的配置信息
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATIONS
            = Arrays.asList(Component.class, Controller.class, Repository.class, Service.class);

    /**
     * 获取容器实例
     * @return
     */
    public static BeanContainer getInstance() {
        return ContainerHolder.HODER.instance;
    }

    private enum ContainerHolder {
        HODER;
        private BeanContainer instance;
        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    /**
     * 容器是否已经加载
     */
    private boolean loaded = false;

    /**
     * 返回当前容器的加载状态
     * @return
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 同步初始化容器
     * @param packageName
     */
    public synchronized void load(String packageName) {
        if (loaded) {
            log.warn("container has been loaded!");
            return;
        }
        Set<Class<?>> packageClasses = ClassUtil.getAllClassByPackage(packageName);
        if (ValidationUtil.isEmpty(packageClasses)) {
            log.warn("no classes found in [{}]", packageName);
            return;
        }
        for (Class<?> clazz : packageClasses) {
            for (Class<? extends Annotation> beanAnnotation : BEAN_ANNOTATIONS) {
                if (clazz.isAnnotationPresent(beanAnnotation)) {
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * 向容器添加一个Bean
     * @param clazz
     * @param object
     * @return
     */
    public Object addBean(Class<?> clazz, Object object) {
        return beanMap.put(clazz, object);
    }

    /**
     * 移除容器中的某个Bean
     * @param clazz
     * @return
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * 根据Class类型获取对应的实例
     * @param clazz
     * @return
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    /**
     * 获取所有的Class对象
     * @return
     */
    public Set<Class<?>> getAllClasses() {
         return beanMap.keySet();
    }

    /**
     * 返回所有的bean对象
     * @return
     */
    public Set<?> getAllBeans() {
        return new HashSet<>(beanMap.values());
    }

    /**
     * 根据注解类型获取所有的Classes集合
     * @param annotation
     * @return
     */
    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        return getAllClasses().stream()
                .filter(c -> c.isAnnotationPresent(annotation))
                .collect(Collectors.toSet());
    }

    /**
     * 根据父类获取所有的Class实例集合
     * @param clazz
     * @return
     */
    public Set<Class<?>> getClassesBySuper(Class<?> clazz) {
        return getAllClasses().stream()
                .filter(c -> clazz.isAssignableFrom(c) && c != clazz)
                .collect(Collectors.toSet());
    }

    /**
     * 当前容器的加载类的数量
     * @return
     */
    public int size() {
        return beanMap.size();
    }

}
