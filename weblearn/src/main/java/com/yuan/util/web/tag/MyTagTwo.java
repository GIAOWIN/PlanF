package com.yuan.util.web.tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 简单的使用方法  【常用】
 */
public class MyTagTwo extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        this.getJspContext().getOut().print("第二次看到啦~~");

    }
}
