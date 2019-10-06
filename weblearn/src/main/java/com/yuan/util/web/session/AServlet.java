package com.yuan.util.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Yuan-9826
 */
@WebServlet("/session/AServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        final HttpSession session = request.getSession();
        session.getId();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
}