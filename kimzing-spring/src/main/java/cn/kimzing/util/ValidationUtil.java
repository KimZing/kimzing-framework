package cn.kimzing.util;

import java.util.Collection;
import java.util.Map;

/**
 * 常用的校验.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/12 01:16
 */
public class ValidationUtil {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isEmpty(T[] ts) {
        return ts == null || ts.length == 0;
    }

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s) || s.trim().length() == 0;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

}
