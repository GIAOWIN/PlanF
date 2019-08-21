package com.yuan.io;

import java.io.*;

/**
 * @author Yuan-9826
 */
public class EasyUtuils {

    public static void main(String[] args) {

        File target = new File("C:\\Users\\ASUS\\Desktop\\新建文件夹");
        String destination = "C:\\Users\\ASUS\\Desktop\\like\\EE";
        String type = ".md";
        copyAll(target,destination,type);
    }
    /**
     * 复制一个文件
     * @param target      目标
     * @param destination 目的地
     */
    public static void copy(File target, String destination) {
        try (
                FileInputStream in = new FileInputStream(target);
                FileOutputStream out = new FileOutputStream(destination+"\\"+target.getName())
        ) {

            int len;
            final byte[] bs = new byte[1024 * 10];
            while ((len = in.read(bs)) != -1) {
                out.write(bs,0,len);
            }
                System.out.println(destination+"\\"+target.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 复制一个文件夹的文件
     * @param target      目标
     * @param destination 目的地
     * @param type 文件类型
     */
    public static void copyAll(File target, String destination, String type) {
        if (target.isDirectory()) {
            //如果是文件夹就递归
            for (File file : target.listFiles()) {
                copyAll(file, destination, type);
            }
        } else {
            //是文件就过滤.pdf结尾的
            if (target.getName().endsWith(type)) {
                //是就调用复制方法
                copy(target, destination);
            }
        }
    }
}
