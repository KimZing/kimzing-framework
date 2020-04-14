package com.kimzing.framework.inject;

import com.kimzing.framework.core.BeanContainer;
import example.scannable.ShopController;
import example.scannable.ShopService;
import example.scannable.sub.ShopMySQLRepositoryImpl;
import example.scannable.sub.ShopServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 依赖注入测试.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/4/14 20:52
 */
public class DependencyInjectorTest {

    @Test
    public void testInject() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        Assertions.assertFalse(beanContainer.isLoaded());
        beanContainer.load("example.scannable");
        Assertions.assertEquals(4, beanContainer.size());
        assertTrue(beanContainer.isLoaded());

        // 验证Controller的成员属性(单个实现)的加载
        ShopController shopController = (ShopController) beanContainer.getBean(ShopController.class);
        Assertions.assertTrue(shopController instanceof ShopController);
        assertNull(shopController.getShopService());
        new DependencyInjector().inject();
        assertNotNull(shopController.getShopService());

        // 通过ShopService的成员属性ShopRepository验证多个实例指定名称加载
        ShopServiceImpl shopServiceImpl = (ShopServiceImpl) beanContainer.getBean(ShopServiceImpl.class);
        assertTrue(shopServiceImpl instanceof ShopService);
        assertTrue(shopServiceImpl.getShopRepository() instanceof ShopMySQLRepositoryImpl);
    }

}
