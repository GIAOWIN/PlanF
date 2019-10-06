package com.yuan.util.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示重定向
 * @author Yuan-9826
 */
@WebServlet(name = "bservlet",value = "/res/bservlet")
public class BServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("BServlet.............");
        /**
         * 重定向
         * 1.设置Location 大小写不影响
         * 2.发送302
         * 注意:跳转的servlet如果是同级目录下 就只写当前路径下后面那段servlet的URL
         */
        response.setHeader("Location","aservlet");
        response.setStatus(302);
    }
}