package com.yuan.util.annotation;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnoTest {
    /**
     * 获取所有类
     */
    private static List<Class> beasns = ScanClass.getBeasns();

    /**
     * 所有有NotNull注解的方法
     */
    private static ArrayList<Method> targetMethod = new ArrayList<>();



    public static void main(String[] args) {

        for (Class beasn : beasns) {
            Method[] methods = beasn.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(NotNull.class)) {
                    targetMethod.add(method);
                }
            }
        }



    }
}
