package com.css.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequest常用方法
 */
@WebServlet("/request01")
public class Request01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的完整路径URL（从"http"开始到"?"前面结束）
        String url = request.getRequestURL().toString();
        System.out.println("请求的完整路径URL:" + url);

        // 获取请求的部分路径URI（从站点名开始到"?"前面结束）
        String uri = request.getRequestURI();
        System.out.println("请求的部分路径URI:" + uri);

        // 获取请求时的参数字符串（从"?"开始到最后）
        String queryString = request.getQueryString();
        System.out.println("请求时的参数字符串:" + queryString);

        // 获取请求方式（GET和POST）
        String method = request.getMethod();
        System.out.println("请求方式:" + method);

        // 获取请求协议（HTTP/1.1）
        String protocol = request.getProtocol();
        System.out.println("请求协议:" + protocol);

        // 获取请求的站点名（项目对外访问路径）
        String webApp = request.getContextPath(); // 上下文路径
        System.out.println("请求的站点名:" + webApp);

        // 获取指定请求名称的参数值
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("name:" + name);
        System.out.println("password:" + password);

        // 获取指定请求参数的所有值（类似复选框传值）
        String[] hobbys = request.getParameterValues("hobby");
        if (hobbys != null && hobbys.length > 0) {
            for (String hobby : hobbys) {
                System.out.println("hobby:" + hobby);
            }
        }

    }
}
