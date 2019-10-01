package com.yuan.web.servlet;

import com.yuan.io.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yuan-9826
 */
@WebServlet("/servlet/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        final String path = UploadUtils.uploadFile(request, "C:\\Users\\ASUS\\Desktop\\");

    }
}