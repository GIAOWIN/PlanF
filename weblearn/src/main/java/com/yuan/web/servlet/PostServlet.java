package com.yuan.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Yuan-9826
 */
@WebServlet("/servlet/PostServlet")
public class PostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String passworld = request.getParameter("passworld");
        System.out.println("passworld = " + passworld);
        final HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("passworld",passworld);
//        request.getRequestDispatcher("/showEncoding.jsp").include(request,response);
        response.getWriter().println(username);
        response.getWriter().println(passworld);
    }

}