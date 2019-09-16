package com.yuan.web.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yuan-9826
 */
@WebServlet("/req/AServlet")
public class AServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String IP = request.getRemoteHost();
        System.out.println("IP : " + IP);
        final String method = request.getMethod();
        System.out.println("请求方式 : " + method);
        final String header = request.getHeader("User-Agent");
        System.out.println("请求头 : " + header);
/*
最后一个请求头就拿到了 操作系统 浏览器等信息
Mozilla
/5.0 (Windows NT 10.0; WOW64) AppleWebKit
/537.36 (KHTML, like Gecko) Chrome
/70.0.3538.25 Safari
/537.36 Core
/1.70.3730.400 QQBrowser
/10.5.3805.400
*/

    }
}