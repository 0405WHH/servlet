package com.css.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie的注意点
 * 1. cookie只在当前浏览器是生效（不能跨浏览器和电脑）
 * 2. 出现同名（name属性）的cookie时会覆盖
 * 3. cookie的存储数量是有上限的，不同浏览器的上限不同
 * 4. cookie的大小是有上限的，上限约为4kb左右
 * 5. cookie不支持存中文，如果一定要存中文
 *    使用URLEncoder.encode()方法进行编码
 *    使用URLDecoder.decode()方法进行解码
 */
@WebServlet("/cookie04")
public class Cookie04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 中文的name和value
        String name = "姓名";
        String value = "王辉";

        // 使用URLEncoder.encode()方法进行编码
        name = URLEncoder.encode(name);
        value = URLEncoder.encode(value);

        //创建cookie对象
        Cookie cookie = new Cookie(name, value);
        // 发送（响应）cookie对象
        response.addCookie(cookie);

        // 获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie1 : cookies) {
                // 使用URLDecoder.decode()方法进行解码
                System.out.println(URLDecoder.decode(cookie1.getName()));
                System.out.println(URLDecoder.decode(cookie1.getValue()));
            }
        }
    }
}
