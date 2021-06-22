package com.css.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session域对象
 * 1. 设置session域对象
 *    session.setAttribute("name", "admin");
 * 2. 移除session域对象
 *    session.removeAttribute("password");
 * 3. 获取session域对象
 *    session.getAttribute("name");
 *
 *    请求转发：                     重定向：
 *    一次请求                       两次请求
 *    session域对象有效              session域对象有效
 *    request域对象有效              request域对象无效
 */
@WebServlet("/session02")
public class Session02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = request.getSession();

        // 设置session域对象
        session.setAttribute("name", "admin");
        session.setAttribute("password", "123456");

        // 移除session域对象
        session.removeAttribute("password");

        // 设置request域对象
        request.setAttribute("rname", "request");

        // 转发请求
        //request.getRequestDispatcher("index.jsp").forward(request,response);

        // 重定向
        response.sendRedirect("index.jsp");

    }
}
