package com.yuan.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * servletContext生死监听
 *
 * @author Yuan-9826
 * <p>
 * 这个监听器用来存放一些 初始化代码的
 */
@WebListener
public class AListener implements ServletContextListener {

    /**
     * servletContext生之后运行 【最有用的监听器】
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("这个监听器出生了..........");
    }

    /**
     * servletContext死之前运行
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("这个监听器去世了..........");

    }
}
