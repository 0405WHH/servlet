package com.css.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * service方法内部是根据请求的方法不同调用了不同的方法
 * get请求调用了doGet()方法
 * post请求调用了doPost方法
 * 所有我们可以实现doGet()方法和doPost方法即可
 */
@WebServlet("/servlet04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello doGet!");
        resp.getWriter().write("hello doGet!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello doPost!");
        resp.getWriter().write("hello doPost!");
    }
}
