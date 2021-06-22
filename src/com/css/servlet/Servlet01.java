package com.css.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现Servlrt
 * 1.创建一个普通的类
 * 2.实现servlet规范，集成HttpServlet类
 * 3.重写service方法，用来处理请求
 * 4.添加注解@WebServlet，指定访问路径
 */
@WebServlet("/servlet01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 打印到控制台
        System.out.println("hello HttpServlet!");
        // 通过流输出数据到浏览器
        resp.getWriter().write("hello HttpServlet!");
    }
}
