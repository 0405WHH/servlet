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
 * 字符流输出数据乱码问题
 * 乱码原因：
 * 对于 getWriter()获取到的字符流，响应中文必定出乱码，由于服务器端在进行编码时默认会使用 ISO-8859-1 格式的编码，该编码方式并不支持中文
 * 解决方案：
 * 1. 设置服务端的字符编码格式
 *    response.setCharacterEncoding("UTF-8");
 * 2. 设置客户端的编码格式和MIME类型
 *    response.setHeader("content-type", "text/html;charset=UTF-8");
 * 总结：设置客户端和服务端的编码格式都支持中文且保持一致即可
 *
 * 有一种可以同时设置客户端和服务端编码格式的方法，以替换上面两步
 * response.setContentType("text/html;charset=UTF-8");
 */
@WebServlet("/response02")
public class Response02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置服务端的字符编码格式
        //response.setCharacterEncoding("UTF-8");

        //设置客户端的编码格式和MIME类型
        //response.setHeader("content-type", "text/html;charset=UTF-8");

        //同时设置客户端和服务端编码格式
        response.setContentType("text/html;charset=UTF-8");

        // 获取字符输出流
        PrintWriter printStream = response.getWriter();
        printStream.write("你好");

    }
}
