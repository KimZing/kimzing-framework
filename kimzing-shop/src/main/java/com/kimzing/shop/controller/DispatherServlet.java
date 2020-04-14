package com.kimzing.shop.controller;

import com.kimzing.shop.controller.frontend.HeadLineShopCategoryController;
import com.kimzing.shop.controller.manager.HeadLineController;
import com.kimzing.controller.manager.ShopCategoryController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问控制分发.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/30 00:00
 */
@Slf4j
@WebServlet("/")
public class DispatherServlet extends HttpServlet {

    HeadLineShopCategoryController headLineShopCategoryController;

    ShopCategoryController shopCategoryController;

    HeadLineController headLineController;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        String method = req.getMethod();
        log.info("path: [{}], method: [{}]", servletPath, method);
        if ("/page/index".equals(servletPath) && "GET".equals(method)) {
            headLineShopCategoryController.getMainPage(req, resp);
        } else if ("/manager/headline".equals(servletPath) && "POST".equals(method)) {
            headLineController.add(req, resp);
        } else if ("/manager/shopcategory".equals(servletPath) && "POST".equals(method)) {
            shopCategoryController.add(req, resp);
        }
    }
}
