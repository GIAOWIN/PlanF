package com.yuan.util.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class NotnullStater {

    public static void main(String[] args) {
        HashMap<Class, ArrayList<Method>> proxyMap = NotNullAnnotation.getProxyMap();


    }
}
