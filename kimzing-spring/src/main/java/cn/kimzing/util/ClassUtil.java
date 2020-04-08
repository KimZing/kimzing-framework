package cn.kimzing.util;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class工具类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/8 14:46
 */
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 获取指定包下的所有Class.
     * <p>
     *
     * </p>
     *
     * @param packageName 包名，以.号分隔
     * @return java.util.Set<java.lang.Class<?>>
     */
    public static Set<Class<?>> getAllClassByPackage(String packageName) {
        // 1. 获取当前上下文的classLoader
        ClassLoader classLoader = getClassLoader();
        // 2. 通过classLoader获取当前包资源
        URL resource = classLoader.getResource(packageName.replace(".", "/"));
        if (Objects.isNull(resource)) {
            return null;
        }
        // 3. 过滤出file的协议资源，并筛选出所有的Class
        if (resource.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            Set<Class<?>> classSet = new HashSet<>();
            File fileDir = new File(resource.getPath());
            findClasses(classSet, fileDir, );
        }
        return null;
    }

    private static void findClasses(Set<Class<?>> classSet, File sourceDir, String packageName) {

    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

}
