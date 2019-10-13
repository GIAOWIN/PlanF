package com.yuan.web.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yuan-9826
 */
@WebServlet("/req/cservlet")
public class CServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String referer = request.getHeader("Referer");
        //这就获取到了访问的来源
        System.out.println("referer = " + referer);
        //可以获取他的IP之类的一通操作

    }
}