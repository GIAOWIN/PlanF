package com.yuan.util.web.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

/**
 * @author Yuan-9826
 */
public class MyTagOne implements SimpleTag {

    private PageContext pageContext;
    private JspFragment body;


    @Override
    /**
     * 标签执行方法
     */
    public void doTag() throws JspException, IOException {
        pageContext.getOut().print("这个是自定义标签");
    }

    @Override
    /**
     * 设置父标签 【这个方法没用】
     */
    public void setParent(JspTag jspTag) {

    }

    @Override
    /**
     * 获取父标签
     */
    public JspTag getParent() {
        return null;
    }

    @Override
    /**
     * 设置PageContext 【这个方法很有用】
     */
    public void setJspContext(JspContext jspContext) {
        pageContext = (PageContext) jspContext;

    }

    @Override
    /**
     * 设置标签体对象
     */
    public void setJspBody(JspFragment jspFragment) {
        this.body = body;
    }
}
