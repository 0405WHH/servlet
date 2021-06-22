package com.css.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session的销毁
 *   当客户端第一次请求 servlet 并且操作 session 时，session 对象生成，
 *   Tomcat 中 session 默认的存活时间为 30min，即你不操作界面的时间，一旦有操作，session 会重新计时。
 * 1. 可以在 Tomcat 中的 conf 目录下的 web.xml 文件中进行修改。
 *     session 默认的最大不活动时间。单位：分钟。
 *       <session-config>
 *         <session-timeout>30</session-timeout>
 *       </session-config>
 * 2. 设置session的最大不活动时间
 *    获取session的最大不活动时间：session.getMaxInactiveInterval()
 *    设置session的最大不活动时间：session.setMaxInactiveInterval(15); 单位：秒
 * 3. session的立即销毁
 *    session.invalidate();
 * 4. 浏览器关闭销毁
 *     session底层是依赖cookie的，cookie默认是在浏览器内存中存储，关闭浏览器cookie消失，session也会销毁
 * 5. 关闭服务器
 */
@WebServlet("/session03")
public class Session03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = request.getSession();

        // 获取session的最大不活动时间
        //System.out.println("session的最大不活动时间：" + session.getMaxInactiveInterval());

        // 设置session的最大不活动时间
        //session.setMaxInactiveInterval(15); //单位：秒

        // session的立即销毁
        session.invalidate();
    }
}
