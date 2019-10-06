package com.yuan.util.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author Yuan-9826
 */
@WebServlet("/req/eservlet")
public class EServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  UnsupportedEncodingException {
        final String username = request.getParameter("username");
        final String passworld = request.getParameter("passworld");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
        doPost(request,response);
    }
}