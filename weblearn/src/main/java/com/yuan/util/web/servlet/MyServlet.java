package com.yuan.util.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Yuan-9826
 */
public class MyServlet implements Servlet {
    /**
     * 生命周期方法 servlet创建之后立即执行
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init..............");
    }

    /**
     * 获取servlet配置信息
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig.........");
        return null;
    }
    /**
     *生命周期方法 每次调用servlet都执行这个方法
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        System.out.println("service.........");
    }
    /**
     * 没用的东西 爱实现不想实现
     *获取servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo............");
        return "我是一个快乐的Servlet";
    }
    /**
     *生命周期方法 servlet销毁之前立即执行
     */
    @Override
    public void destroy() {
        System.out.println("destroy................");
    }
}
