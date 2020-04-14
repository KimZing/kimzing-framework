package com.kimzing.framework.inject;

import com.kimzing.framework.core.BeanContainer;
import com.kimzing.framework.inject.annotation.Autowired;
import com.kimzing.framework.util.ClassUtil;
import com.kimzing.framework.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;

/**
 * 依赖注入实现.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/14 19:19
 */
@Slf4j
public class DependencyInjector {

    private BeanContainer beanContainer;

    public DependencyInjector() {
        beanContainer = BeanContainer.getInstance();
    }

    /**
     * 执行依赖注入
     */
    public void inject() {
        // 1. 遍历Bean容器中所有的Class对象
        Set<Class<?>> classes = beanContainer.getAllClasses();
        if (ValidationUtil.isEmpty(classes)) {
            log.warn("no classes in container");
            return;
        }
        for (Class<?> clazz : classes) {
            // 2. 获取Class对象的所有成员变量
            Field[] declaredFields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(declaredFields)) {
                continue;
            }
            for (Field declaredField : declaredFields) {
                // 3. 找出被标记@Autowired的成员
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    Autowired annotation = declaredField.getAnnotation(Autowired.class);
                    String value = annotation.value();
                    // 4. 获取成员的类型
                    Class<?> fieldClass = declaredField.getType();
                    // 5. 查找容器内对应的实例
                    Object fieldInstance = getFieldInstance(fieldClass, value);
                    // 6. 通过反射注入对应成员的值
                    ClassUtil.setFieldValue(declaredField, beanContainer.getBean(clazz), fieldInstance, true);
                }
            }
        }
    }

    private Object getFieldInstance(Class<?> fieldClass, String value) {
        Object bean = beanContainer.getBean(fieldClass);
        if (!Objects.isNull(bean)) {
            return bean;
        }
        bean = getImplementionInstance(fieldClass, value);
        if (!Objects.isNull(bean)) {
            return bean;
        } else {
            throw new RuntimeException("can not get ImplementionInstance of " + fieldClass.getSimpleName());
        }
    }

    private Object getImplementionInstance(Class<?> fieldClass, String value) {
        Set<Class<?>> classesBySuper = beanContainer.getClassesBySuper(fieldClass);
        if (ValidationUtil.isEmpty(classesBySuper)) {
            return  null;
        }
        if (ValidationUtil.isEmpty(value) && classesBySuper.size() == 1) {
            return beanContainer.getBean(classesBySuper.iterator().next());
        }
        if (ValidationUtil.isEmpty(value) && classesBySuper.size() > 1) {
            throw new RuntimeException("found multi bean");
        }
        for (Class<?> clazz : classesBySuper) {
            if (value.equalsIgnoreCase(clazz.getSimpleName())) {
                return beanContainer.getBean(clazz);
            }
        }
        return null;
    }

}
