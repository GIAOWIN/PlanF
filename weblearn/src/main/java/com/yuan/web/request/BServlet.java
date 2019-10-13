package com.yuan.web.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yuan-9826
 */
@WebServlet("/req/BServlet")
public class BServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //协议
        response.getWriter().print("<h1>"+request.getScheme()+"</br></h1>");
        //主机名
        response.getWriter().print("<h1>"+request.getServerName()+"</br></h1>");
        //端口
        response.getWriter().print("<h1>"+request.getServerPort()+"</br></h1>");
        //项目名
        response.getWriter().print("<h1>"+request.getContextPath()+"</br></h1>");
        //Servlet路径
        response.getWriter().print("<h1>"+request.getServletPath()+"</br></h1>");
        //参数
        response.getWriter().print("<h1>"+request.getQueryString()+"</br></h1>");
        //URI
        response.getWriter().print("<h1>"+request.getRequestURI()+"</br></h1>");
        //URL
        response.getWriter().print("<h1>"+request.getRequestURL()+"</br></h1>");
    }
}