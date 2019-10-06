package com.yuan.util.web.servlet;

import com.yuan.util.encoding.EncodeingUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Yuan-9826
 */
@WebServlet("/servlet/FileDawnloadServlet")
public class FileDawnloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String path = "C:\\Users\\ASUS\\Desktop\\";
        String fileName = "java工程师笔试题-中文.doc";
        String frameName = EncodeingUtils.g2i(fileName);
        String contentType = this.getServletContext().getMimeType(frameName);

        String contentDisposition = "attachment;filename=" + frameName;
        //两个头
        response.setHeader("Content-type", contentType);
        response.setHeader("Content-Disposition", contentDisposition);
        //一个流
        FileInputStream in = null;
        try {
            in = new FileInputStream(path + fileName);
            //绑定响端的流
            ServletOutputStream out = response.getOutputStream();

            IOUtils.copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
