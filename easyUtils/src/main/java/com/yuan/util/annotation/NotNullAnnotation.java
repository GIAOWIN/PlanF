package com.yuan.util.annotation;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;


public class NotNullAnnotation {
    private static List<Class> beasns = new ArrayList();
    private static String classpath = Thread.currentThread().getContextClassLoader().getResource(".").getPath();





    public static void initBean(File path) {
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                initBean(file);
            } else {
                if (file.toString().endsWith(".class")) {
                    String className = file.toString().substring(classpath.length() + 1, file.toString().length() - 6).replace("\\", ".");
                    try {
                        final Class<?> clazz = Class.forName(className);
                        System.out.println("className = " + className);
                        beasns.add(clazz);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        initBean(new File(classpath));
        //1.遍历所有类
        for (Class bean : beasns) {
            //2.把有方法含有@NotNull 注解的方法都找出来
            Method[] mathods = bean.getDeclaredMethods();
            //2.1遍历每个类中的所有方法
            for (Method method : mathods) {
                //2.2如果有目标注解就获取
                if (method.isAnnotationPresent(NotNull.class)) {

/*                    //3.获取之后看看参数的值是不是空的
                    Parameter[] parameters = method.getParameters();
                    //3.1
                    for (Parameter parameter : parameters) {
                        if (parameter == null) {
                            System.out.println(parameter + "这个值是空的");
                        }
                    }*/
                }
            }
        }
    }

}
