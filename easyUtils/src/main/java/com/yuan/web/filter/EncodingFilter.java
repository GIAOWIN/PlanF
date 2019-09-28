package com.yuan.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 乱码过滤器
 */
public class EncodingFilter implements Filter {

    private String GET = "GET";
    private String POST = "POST";
    private Integer version = 8;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("编码过滤器执行");
        final String version = filterConfig.getInitParameter("tomcatVersion");
        this.version = Integer.valueOf(version);
        System.out.println(version);

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //处理post请求编码问题
        req.setCharacterEncoding("utf-8");

        /**
         * tomcat1.8之后自己做了get请求的处理
         */
        if (version < 8) {
            System.out.println("Tomcat版本低于8 做GET请求处理");
            //掉包request 和 HttpServletRequest
            HttpServletRequest request = (HttpServletRequest) req;
            //放行时
            if (GET.equals(request.getMethod())) {
                HttpRequest hr = new HttpRequest(request);
                chain.doFilter(hr, res);
            } else if (POST.equals(request.getMethod())) {
                chain.doFilter(req, res);
            }
        }else {
            chain.doFilter(req, res);
            System.out.println("Tomcat版本不低于8 不做GET请求处理");
        }
    }

    @Override
    public void destroy() {

    }
}
