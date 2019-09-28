package com.yuan.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class BFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("BFilter出生啦");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int a = 1;
        System.out.println("BFilter第 "+ a++ +" 次执行");
        chain.doFilter(request,response);
        System.out.println("BFilter第 "+ a++ +" 次执行");

    }

    @Override
    public void destroy() {
        System.out.println("BFilter去世啦");
    }
}
