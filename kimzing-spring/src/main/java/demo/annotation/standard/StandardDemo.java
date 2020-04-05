package demo.annotation.standard;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准注解示例.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/4 01:21
 */
@SuppressWarnings(value = {"unused", "rawtypes"})
public class StandardDemo extends Parent{

    @Override
    public void sayHello() {
        // unused 声明了list却没有使用
        // rawtypes 创建了泛型类却没有指定元素类型
        List list = new ArrayList();
    }

    @Deprecated
    public void walk() {

    }

}
