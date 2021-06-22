package com.css.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie的创建与发送
 */
@WebServlet("/cookie01")
public class Cookie01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Cookie对象
        Cookie cookie = new Cookie("name", "admin");

        // 发送（响应）cookie对象
        response.addCookie(cookie);
    }
}
