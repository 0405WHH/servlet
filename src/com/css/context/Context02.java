package com.css.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext域对象：
 * 1. 设置域对象 context.setAttribute("name", "admin");
 * 2. 获取域对象 context.getAttribute("name");
 * 3. 移除域对象 context.removeAttribute("name");
 *
 * Servlet的三大域对象
 * 1. request域对象
 *    在一次请求中有效。请求转发有效，重定向失效。
 * 2. session域对象
 *    在一次会话中有效。请求转发和重定向都有效，session销毁后失效。
 * 3. servletContext域对象
 *    在整个应用程序中有效。服务器关闭后失效。
 */
@WebServlet("/context02")
public class Context02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过request获取
        ServletContext context = request.getServletContext();

        // 设置域对象
        context.setAttribute("name", "admin");

        // 获取域对象
        String name = (String) context.getAttribute("name");
        System.out.println("name: " + name);

        // 移除域对象
        context.removeAttribute("name");


    }
}
