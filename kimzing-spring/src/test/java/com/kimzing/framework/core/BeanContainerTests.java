package com.kimzing.framework.core;

import com.kimzing.framework.core.annotation.Controller;
import example.scannable.ShopRepository;
import example.scannable.sub.ShopMySQLRepositoryImpl;
import example.scannable.sub.ShopServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DisplayName("容器测试类")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTests {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void initContainer() {
        beanContainer = BeanContainer.getInstance();
    }

    @Order(1)
    @DisplayName("测试容器加载")
    @ParameterizedTest(name = "{displayName}-{index}-{arguments}")
    @ValueSource(strings = {"example.scannable"})
    void testLoad(String packageName) {
        Assertions.assertFalse(beanContainer.isLoaded());
        beanContainer.load(packageName);
        Assertions.assertEquals(4, beanContainer.size());
        assertTrue(beanContainer.isLoaded());
    }

    @DisplayName("测试获取对应Class的实例")
    @Order(2)
    @Test
    void testGetBeanOfClass() {
        Object shopServiceImpl = beanContainer.getBean(ShopServiceImpl.class);
        Assertions.assertTrue(shopServiceImpl instanceof ShopServiceImpl);
        Object shopRepository = beanContainer.getBean(ShopRepository.class);
        Assertions.assertEquals(null, shopRepository);
    }

    @DisplayName("测试通过注解获取对应的Class实例集合")
    @Order(3)
    @Test
    void testGetClassesByAnnotation() {
        Set<Class<?>> classesByAnnotation = beanContainer.getClassesByAnnotation(Controller.class);
        Assertions.assertEquals(1, classesByAnnotation.size());
    }

    @DisplayName("测试通过父类获取Class实例集合")
    @Order(4)
    @Test
    void testGetClassesBySuper() {
        Set<Class<?>> classesBySuper = beanContainer.getClassesBySuper(ShopRepository.class);
        Assertions.assertEquals(2, classesBySuper.size());
        Assertions.assertTrue(classesBySuper.contains(ShopMySQLRepositoryImpl.class));

        Set<Class<?>> classesBySuper1 = beanContainer.getClassesBySuper(ShopMySQLRepositoryImpl.class);
        Assertions.assertTrue(classesBySuper1.size() == 0);
    }

    @BeforeAll
    static void init() {
        log.info("started");
    }

    @AfterAll
    static void destory() {
        log.info("finished");
    }

    @BeforeEach
    void before(TestInfo testInfo) {
        log.info("=================> [{}]", testInfo.getDisplayName());
    }

    @AfterEach
    void after(TestInfo testInfo) {
        log.info("<================= [{}]", testInfo.getDisplayName());
    }

}
