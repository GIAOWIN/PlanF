package com.yuan.util.annotation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫描获取所有类路径下的类
 */
public class ScanClass {

    /**
     * 开发者开的类对象
     */
    private static List<Class> beasns = new ArrayList();
    /**
     * classpath绝对路径
     */
    private static  String classpath = Thread.currentThread().getContextClassLoader().getResource(".").getPath();

    /**
     * bean添加到集合
     */
    static {
        initBean(new File(classpath));
        System.out.println("ScanClass");
    }

    /**
     * 将class path下所有的Class文件加载到内存中创建对象
     *
     * @param path
     */
    public static void initBean(File path) {
        File[] files = path.listFiles();
        for (File file : files) {
            //如果是文件夹就遍历
            if (file.isDirectory()) {
                initBean(file);
                //是.class文件就加载并添加到beans集合中
            } else {
                if (file.toString().endsWith(".class")) {
                    //获取全类名
                    String className = getClassName(file);
                    //加载
                    loadClass(className);
                }
            }
        }
    }

    /**
     * 将文件名转化成全类名
     *
     * @param file
     * @return
     */
    public static String getClassName(File file) {
        return file.toString().substring(classpath.length() - 1, file.toString().length() - 6).replace("\\", ".");
    }

    /**
     * 加载全类名的类并添加到集合中
     *
     * @param className
     */
    public static void loadClass(String className) {
        try {
            Class clazz = Class.forName(className);
            beasns.add(clazz);
        } catch (Exception e) {
            new RuntimeException("加载类失败");
        }
    }

    /**
     *
     * @return 类路径下所有资源
     */
    public static List<Class> getBeasns() {
        return beasns;
    }
}
