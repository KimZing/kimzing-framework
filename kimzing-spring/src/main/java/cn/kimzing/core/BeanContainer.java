package cn.kimzing.core;

import cn.kimzing.core.annotation.Component;
import cn.kimzing.core.annotation.Controller;
import cn.kimzing.core.annotation.Repository;
import cn.kimzing.core.annotation.Service;
import cn.kimzing.util.ClassUtil;
import cn.kimzing.util.ValidationUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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

    public boolean isLoaded() {
        return loaded;
    }

    public int size() {
        return beanMap.size();
    }

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

}
