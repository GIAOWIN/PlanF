package com.yuan.util.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class BListener implements ServletContextAttributeListener {

    /**
     *添加属性时调用
     * @param event
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
      //  System.out.println("您添加了一个名为 "+event.getName()+" ,值为 "+event.getValue()+"的属性");
    }

    /**
     *替换属性时调用
     * @param event
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }

    /**
     *删除属性时调用
     * @param event
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {

    }
}
