package kimzing.core;

import cn.kimzing.core.BeanContainer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("容器测试类")
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void init() {
        System.out.println("started");
        beanContainer = BeanContainer.getInstance();
    }

    @AfterAll
    static void destory() {
        System.out.println("finished");
    }


    @BeforeEach
    void before() {
        System.out.print("=================>");
    }

    @AfterEach
    void after() {
        System.out.println("<=================");
    }



    @DisplayName("测试容器加载")
    @ParameterizedTest(name = "{displayName}-{index}-{arguments}")
    @ValueSource(strings = {"com.kimzing.controller"})
    void testLoad(String packageName, TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        Assertions.assertFalse(beanContainer.isLoaded());
        beanContainer.load(packageName);
        Assertions.assertEquals(3, beanContainer.size());
        assertTrue(beanContainer.isLoaded());
    }

}
