package com.kimzing.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 首页.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/28 14:09
 */
@Slf4j
@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (log.isDebugEnabled()) {
            log.debug("首页访问请求!");
        }
        resp.getWriter().write("Hello");
    }

}
