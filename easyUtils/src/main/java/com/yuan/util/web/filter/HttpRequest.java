package com.yuan.util.web.filter;

import com.yuan.util.encoding.EncodeingUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 被掉包了的Request
 */
public class HttpRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public HttpRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    /**
     * 处理编码问题
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {

        String value = request.getParameter(name);
        return EncodeingUtils.i2u(value);

    }
}

