package com.css.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext对象：
 *   每一个 web 应用都有且仅有一个ServletContext 对象，又称 Application 对象，从名称中可知，该对象是与应用程序相关的。
 *   在 WEB 容器启动的时候，会为每一个 WEB 应用程序创建一个对应的ServletContext 对象
 *
 * 获取ServletContext对象的方法：
 * 1. 通过request获取 request.getServletContext();
 * 2. 通过session获取 request.getSession().getServletContext();
 * 3. 通过ServletConfig获取 getServletConfig().getServletContext();
 * 4. 直接获取 getServletContext();
 *
 * ServletContext对象常用方法
 * 1. 获取服务信息    getServerInfo();
 * 2. 获取项目真实路径 getRealPath("/")
 */
@WebServlet("/context01")
public class Context01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过request获取
        ServletContext context1 = request.getServletContext();

        // 通过session获取
        ServletContext context2 = request.getSession().getServletContext();

        // 通过ServletConfig获取
        ServletContext context3 = getServletConfig().getServletContext();

        // 直接获取
        ServletContext context4 = getServletContext();

        // 获取服务信息
        String serverInfo = request.getServletContext().getServerInfo();
        System.out.println("serverInfo: " + serverInfo);

        // 获取项目真实路径
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath: " + realPath);
    }
}
