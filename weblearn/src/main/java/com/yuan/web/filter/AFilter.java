package com.yuan.web.filter;

import javax.servlet.*;
import java.io.IOException;


public class AFilter implements Filter {
    /**
     * 初始化 创建后立即执行
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AFilter出生啦");
    }

    /**
     * 每次过滤时都会执行
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int a = 1;
        System.out.println("AFilter第 "+ a++ +" 次执行");
        chain.doFilter(request,response);
        System.out.println("AFilter第 "+ a++ +" 次执行");
    }

    /**
     * 销毁前立即执行
     */
    @Override
    public void destroy() {

        System.out.println("AFilter去世啦");
    }
}
