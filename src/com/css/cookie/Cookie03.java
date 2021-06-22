package com.css.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie的存活时间：
 *  通过setMaxAge()设置
 *
 * 1. 负整数
 *   cookie 的 maxAge 属性的默认值就是-1，表示只在浏览器内存中存活，一旦关闭浏览器窗口，那么 cookie 就会消失。
 * 2. 正整数
 *   表示 cookie 对象可存活指定的秒数。当生命大于0时，浏览器会把 Cookie 保存到硬盘上，
 *   就算关闭浏览器，就算重启客户端电脑，cookie 也会存活相应的时间。
 * 3. 零
 *   cookie 生命等于 0 是一个特殊的值，它表示 cookie 被作废！也就是说，如果原来浏览器已经保存了这个 Cookie，
 *   那么可以通过 Cookie 的 setMaxAge(0)来删除这个 Cookie。无论是在浏览器内存中，还是在客户端硬盘上都会删除这个 Cookie。
 */
@WebServlet("/cookie03")
public class Cookie03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 负整数
        Cookie cookie1 = new Cookie("name1", "admin1");
        cookie1.setMaxAge(-1);
        response.addCookie(cookie1);

        // 正整数
        Cookie cookie2 = new Cookie("name2", "admin2");
        cookie2.setMaxAge(30); //存活30秒
        response.addCookie(cookie2);

        // 零
        Cookie cookie3 = new Cookie("name3", "admin3");
        cookie3.setMaxAge(0); // 删除cookie
        response.addCookie(cookie3);


    }
}
