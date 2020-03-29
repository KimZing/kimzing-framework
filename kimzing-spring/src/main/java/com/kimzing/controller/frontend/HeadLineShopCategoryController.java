package com.kimzing.controller.frontend;

import com.kimzing.service.combine.HeadLineShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 00:03
 */
public class HeadLineShopCategoryController {

    HeadLineShopCategoryService headLineShopCategoryService;

    public void getMainPage(HttpServletRequest req, HttpServletResponse resp) {
        headLineShopCategoryService.getMainPage();
    }
}
