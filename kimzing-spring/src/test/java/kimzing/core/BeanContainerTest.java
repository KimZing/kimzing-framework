package kimzing.core;

import cn.kimzing.core.BeanContainer;
import org.junit.jupiter.api.*;

public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    public static void init() {
        beanContainer = BeanContainer.getInstance();
    }

    @Test
    public void testLoad() {
        Assertions.assertFalse(beanContainer.isLoaded());
        beanContainer.load("com.kimzing.controller");
        Assertions.assertEquals(3, beanContainer.size());
        Assertions.assertTrue(beanContainer.isLoaded());

    }

}
