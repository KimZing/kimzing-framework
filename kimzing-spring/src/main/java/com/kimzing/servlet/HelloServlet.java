package com.kimzing.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 初始化Servlet.
 *
 * @author KimZing - kimzing@163.com
 * @since 2020/3/25 14:01
 */
@WebServlet(name = "hello", urlPatterns = {"/hello"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String name = req.getParameter("name");
        name = name == null ? "default" : name;
        resp.getWriter().write(String.format("Hello %s from %s", name, contextPath));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("name", name);
        req.setAttribute("title", "欢迎访问");
        req.getRequestDispatcher("response.jsp").forward(req, resp);
    }
}
