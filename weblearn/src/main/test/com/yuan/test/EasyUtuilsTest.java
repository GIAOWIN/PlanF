package com.yuan.test;

import com.yuan.io.EasyUtuils;

import java.io.File;

public class EasyUtuilsTest {
    public static void main(String[] args) {
        File target = new File("D:\\PlanG\\JavaEE\\JavaWeb\\class\\JavaWeb\\");
        String destination = "C:\\Users\\ASUS\\Desktop\\cxf\\new";
        String type = ".md";
        EasyUtuils.copyAll(target,destination,type);
    }
}
