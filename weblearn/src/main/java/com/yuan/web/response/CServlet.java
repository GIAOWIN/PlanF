package com.yuan.web.response;

        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

/**
 * 演示定时重定向
 * @author Yuan-9826
 */
@WebServlet("/res/cservlet")
public class CServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //发送响应体
        response.getWriter().println("这就是响应体");
        response.getWriter().println("This is responseBody");
        response.setHeader("Refresh","5;URL=bservlet");
    }
}