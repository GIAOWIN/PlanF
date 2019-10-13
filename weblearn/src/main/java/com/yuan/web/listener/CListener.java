package com.yuan.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.LinkedHashMap;

@WebListener()
public class CListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.创建ServletContext
        ServletContext application = sce.getServletContext();
        //2.Map
        HashMap<String, Integer> ipMap = new LinkedHashMap<>();
        //3.把Map保存到ServletContext中
        application.setAttribute("ipMap",ipMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
