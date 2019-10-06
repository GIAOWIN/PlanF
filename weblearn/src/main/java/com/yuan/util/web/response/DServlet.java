package com.yuan.util.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Yuan-9826
 */
@WebServlet("/res/dservlet")
public class DServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("pragma", "no-cache");
        response.setDateHeader("expires", -1);
        System.out.println("DServlet................");
        response.getWriter().println(new Date());
        //这么做页面就会刷新个不停
        response.setHeader("Refresh","0;URL=dservlet");
    }
}