package com.css.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * HttpServlet类继承自GenericServlet
 * 所有实现GenericServlet类也可以实现
 */
@WebServlet("/servlet02")
public class Servlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello GenericServlet!");
        servletResponse.getWriter().write("hello GenericServlet!");
    }
}
