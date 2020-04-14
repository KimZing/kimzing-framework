package com.kimzing.framework.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@DisplayName("容器测试类")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

    private static BeanContainer beanContainer;

    @BeforeAll
    static void initContainer() {
        beanContainer = BeanContainer.getInstance();
    }

    @Order(1)
    @DisplayName("测试容器加载")
    @ParameterizedTest(name = "{displayName}-{index}-{arguments}")
    @ValueSource(strings = {"example.scannable"})
    void testLoad(String packageName, TestInfo testInfo) {
        Assertions.assertFalse(beanContainer.isLoaded());
        beanContainer.load(packageName);
        Assertions.assertEquals(3, beanContainer.size());
        assertTrue(beanContainer.isLoaded());
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
