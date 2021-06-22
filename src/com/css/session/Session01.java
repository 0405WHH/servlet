package com.css.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session的常用方法
 */
@WebServlet("/session01")
public class Session01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象，存在则返回，不存在则创建后返回
        HttpSession session = request.getSession();

        // 获取session的会话标识符
        String id = session.getId();
        System.out.println("会话id：" + id);

        // 获取session的创建时间
        System.out.println(session.getCreationTime());

        // 获取最后一次访问时间
        System.out.println(session.getLastAccessedTime());

        // 获取session对象是否是新创建的
        System.out.println(session.isNew());
    }
}
