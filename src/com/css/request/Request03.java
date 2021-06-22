package com.css.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发：把请求转发到另一个servlet或者html或者jsp页面
 * 特点：
 * 1. 服务器行为
 * 2. 地址栏不会发生改变
 * 3. 从始至终只有一个请求
 * 4. request数据共享
 */
@WebServlet("/request03")
public class Request03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("来自Request03的name：" + name);

        // 转发到request04
        //request.getRequestDispatcher("/request04").forward(request,response);

        //转发到jsp页面
        request.getRequestDispatcher("/login.jsp").forward(request,response);

    }
}
