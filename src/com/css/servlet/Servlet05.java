package com.css.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet的生命周期
 */
@WebServlet("/servlet05")
public class Servlet05 extends HttpServlet {
    /**
     * 服务方法，用来处理请求
     * 系统方法，服务器自动调用
     * 当请求到达该servlet时，该方法就会被调用
     * 该方法可以被多次调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service方法被调用。。。");
    }

    /**
     * 销毁方法
     * 系统方法，服务器自动调用
     * 当服务器关闭或应用程序停止时调用
     * 该方法只会被调用一次
     */
    @Override
    public void destroy() {
        System.out.println("servlet实例被销毁。。。");
    }

    /**
     * 初始化方法
     * 系统方法，服务器自动调用
     * 当请求到达servlet容器时，servlet容器会判断该servlet是否存在
     * 如果不存在创建实例并初始化
     * 该方法只会被调用一次
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("servlet被创建。。。");
    }
}
