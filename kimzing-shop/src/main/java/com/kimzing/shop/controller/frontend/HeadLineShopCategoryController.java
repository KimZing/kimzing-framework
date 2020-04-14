package com.kimzing.shop.controller.frontend;

import com.kimzing.framework.core.annotation.Controller;
import com.kimzing.shop.service.combine.HeadLineShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 00:03
 */
@Controller
public class HeadLineShopCategoryController {

    HeadLineShopCategoryService headLineShopCategoryService;

    public void getMainPage(HttpServletRequest req, HttpServletResponse resp) {
        headLineShopCategoryService.getMainPage();
    }
}
