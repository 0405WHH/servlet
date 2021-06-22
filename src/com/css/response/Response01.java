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
 * 获取字符输出流：response.getWriter();
 * 获取字节输出流：response.getOutputStream();
 *
 * 两者不能同时使用，因为response对象已经使用过了
 * 同时使用会抛出java.lang.IllegalStateException: 已为此响应调用getWriter（）
 */
@WebServlet("/response01")
public class Response01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取字符输出流
        PrintWriter printStream = response.getWriter();
        printStream.write("hello");

        // 获取字节输出流
        ServletOutputStream out = response.getOutputStream();
        out.write("hi".getBytes());
    }
}
