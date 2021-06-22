package com.css.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决中文乱码问题
 * 乱码原因：在解析过程中默认使用的编码方式为 ISO-8859-1。此编码不支持中文
 * GET请求：在Tomcat8版本以上不会出现乱码问题,Tomcat8以下版本会出现乱码问题
 * 解决方式：String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
 * POST请求：在Tomcat8版本以上会出现乱码问题,Tomcat8以下版本也会出现乱码问题
 * 解决方式：通过设置服务器解析编码的格式为UTF-8，request.setCharacterEncoding("UTF-8");
 *
 * 注意：request.setCharacterEncoding("UTF-8")方式只能解决针对POST请求乱码问题
 * new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8")可以解决任何乱码问题
 * 但是该方法如果在本身不乱码的情况下（Tomcat8以上版本的GET请求中）会出现另外的乱码问题
 */
@WebServlet("/request02")
public class Request02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置服务器解析编码的格式
        request.setCharacterEncoding("UTF-8");

        // 获取请求参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("姓名：" + name);
        System.out.println("密码：" + password);

        // 只针对Tomcat8以下版本
        //String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
    }
}
