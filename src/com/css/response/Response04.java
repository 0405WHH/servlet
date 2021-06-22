package com.css.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 重定向：
 *   重定向是一种服务器指导，客户端的行为。客户端发出第一个请求，被服务器接收处理后，服务器会进行响应，在响应的同时，
 *   服务器会给客户端一个新的地址（下次请求的地址response.sendRedirect(url);），当客户端接收到响应后，会立刻、马上、自动根据服务器给的新地址
 *   发起第二个请求，服务器接收请求并作出响应，重定向完成。
 *
 *   第一次请求获得的响应码为 302，并且含有一个 location 头包含了重定向的地址
 *
 *  特点：
 *     1. 服务端指导,客户端行为
 *     2. 存在两次请求（request不共享）
 *     3. 地址栏会发生改变
 */
@WebServlet("/response04")
public class Response04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Response04");

        // 重定向到Response05
        response.sendRedirect("response05");
    }
}
