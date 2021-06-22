package com.css.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie的路径：
 *   Cookie的setPath设置cookie的路径，这个路径直接决定服务器的请求是否会从浏览器中加载某些cookie。
 * 1. 当前服务器下任何项目的任意资源都可获取Cookie对象
 *       设置路径为"/"，表示在当前服务器下任何项目都可访问到Cookie对象
 * 2. 当前项目下的资源可获取Cookie对象 （默认不设置Cookie的path）
 *       设置路径为"/servlet01"或者不设置path属性，表示在当前项目下任何项目都可访问到Cookie对象
 * 3. 指定项目下的资源可获取Cookie对象
 *       设置项目为"/servlet02"，表示在servlet02项目下任何项目都可访问到Cookie对象，其他项目包括本项目都不能访问
 * 4. 指定目录下的资源可获取Cookie对象
 *       设设置路径为"/servlet01/cookie05"，表示在servlet01/cookie05目录下才可访问到Cookie对象
 *
 * 总结：当访问的路径包含了cookie的路径时，则该请求将带上该cookie；
 *      如果访问路径不包含cookie路径，则该请求不会携带该cookie。
 */
@WebServlet("/cookie05")
public class Cookie05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 当前服务器下任何项目的任意资源都可获取Cookie对象
        Cookie cookie1 = new Cookie("name1", "admin1");
        // 设置路径为"/"，表示在当前服务器下任何项目都可访问到Cookie对象
        cookie1.setPath("/");
        response.addCookie(cookie1);

        // 当前项目下的资源可获取Cookie对象 （默认不设置Cookie的path）
        Cookie cookie2 = new Cookie("name2", "admin2");
        // 设置路径为"/servlet01"或者不设置path属性，表示在当前项目下任何项目都可访问到Cookie对象
        cookie2.setPath("/servlet01");
        response.addCookie(cookie2);

        // 指定项目下的资源可获取Cookie对象
        Cookie cookie3 = new Cookie("name3", "admin3");
        // 设置项目为"/servlet02"，表示在servlet02项目下任何项目都可访问到Cookie对象，其他项目包括本项目都不能访问
        cookie3.setPath("/servlet02");
        response.addCookie(cookie3);

        // 指指定目录下的资源可获取Cookie对象
        Cookie cookie4 = new Cookie("name4", "admin4");
        // 设置路径为"/servlet01/cookie05"，表示在servlet01/cookie05目录下才可访问到Cookie对象
        cookie4.setPath("/servlet01/cookie05");
        response.addCookie(cookie4);


    }
}
