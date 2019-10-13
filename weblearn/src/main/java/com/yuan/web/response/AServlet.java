package com.yuan.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示发送状态码
 * @author Yuan-9826
 */
@WebServlet(name = "aservlet",value = "/res/aservlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("成功访问.......");
        response.sendError(404,"对不起，您访问的资源存在，但就是不给您看！");
    }
}