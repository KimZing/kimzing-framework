package com.kimzing.framework.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class工具类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/8 14:46
 */
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取指定包下的所有Class.
     * <p>
     *
     * </p>
     *
     * @param packageName 包名，以.号分隔
     * @return java.util.Set<java.lang.Class < ?>>
     */
    @SneakyThrows
    public static Set<Class<?>> getAllClassByPackage(String packageName) {
        // 1. 获取当前上下文的classLoader
        ClassLoader classLoader = getClassLoader();
        // 2. 通过classLoader获取当前包资源
        URL resource = classLoader.getResource(packageName.replace(".", "/"));
        if (Objects.isNull(resource)) {
            return null;
        }
        // 3. 过滤出file的协议资源，并筛选出所有的Class
        Set<Class<?>> classSet = null;
        if (resource.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            Path path = Paths.get(resource.toURI());
            classSet = findClasses(path, packageName);
        }
        return classSet;
    }

    public static <T> T newInstance(Class<T> clazz, boolean access) {
        try {
            Constructor<T> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(access);
            return declaredConstructor.newInstance();
        } catch (Exception e) {
            log.error("can not instance [{}]", clazz);
            throw new RuntimeException(e);
        }
    }

    private static Set<Class<?>> findClasses(Path path, String packageName) {
        if (!Files.isDirectory(path)) {
            return Collections.emptySet();
        }
        try {
            return Files.walk(path)
                    .map(p -> p.toString())
                    .filter(s -> s.endsWith(".class"))
                    .map(s -> s.replace(path.getFileSystem().getSeparator(), "."))
                    .map(s -> s.substring(s.indexOf(packageName)))
                    .map(s -> s.substring(0, s.lastIndexOf(".")))
                    .map(ClassUtil::getClass)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private static Class<?> getClass(String packageName) {
        try {
            return Class.forName(packageName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
