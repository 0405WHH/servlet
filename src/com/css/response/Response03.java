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
 * 字节流输出数据乱码问题
 * 乱码原因：
 *   对于 getOutputStream()方式获取到的字节流，响应中文时，由于本身就是传输的字节， 所以此时可能出现乱码，也可能正确显示。
 *   当服务器端给的字节恰好和客户端使用的编码方式一致时则文本正确显示，否则出现乱码。无论如何我们都应该准确掌握服务器和客户端使用的是那种编码格式，
 *   以确保数据正确显示。
 * 解决方式和字符流完全相同：
 *  1. 设置服务端的字符编码格式
 *     response.setCharacterEncoding("UTF-8");
 *  2. 设置客户端的编码格式和MIME类型
 *     response.setHeader("content-type", "text/html;charset=UTF-8");
 *  总结：设置客户端和服务端的编码格式都支持中文且保持一致即可
 *  有一种可以同时设置客户端和服务端编码格式的方法，以替换上面两步
 *  response.setContentType("text/html;charset=UTF-8");
 */
@WebServlet("/response03")
public class Response03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置服务端的字符编码格式
        //response.setCharacterEncoding("UTF-8");

        //设置客户端的编码格式和MIME类型
        //response.setHeader("content-type", "text/html;charset=UTF-8");

        //同时设置客户端和服务端编码格式
        response.setContentType("text/html;charset=UTF-8");

        // 获取字节输出流
        ServletOutputStream out = response.getOutputStream();
        out.write("你好".getBytes());
    }
}
