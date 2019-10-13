package com.yuan.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Yuan-9826
 */
public class ProxyFactory {
    /**
     * 目标对象
     */
    public volatile Object object;
    /**
     * 前置增强
     */
    private AfterEnhance after;
    /**
     * 后置增强
     */
    private BeforeEnhance before;


    public ProxyFactory(Object object) {
        this.object = object;
    }

    public void setAfter(AfterEnhance after) {
        this.after = after;
    }

    public void setBefore(BeforeEnhance before) {
        this.before = before;
    }

    public Object createProxy() {
        /**
         * 给出三大参数
         * 1.目标对象类加载器
         * 2.目标对象接口
         * 3.增强方法
         */
        ClassLoader classLoader = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            //前置增强
            if (after != null) {
                after.after();
            }
            System.out.println("我被 " + method + " 方法调用了,参数是 " + Arrays.toString(args));
            Object invoke = method.invoke(object, args);
            //后置增强
            if (before != null) {
                before.before();
            }
            return invoke;
        };
        /**
         * 得到代理对象
         */
        Object obj = Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        return obj;
    }
}
/*
class ExMethod implements InvocationHandler {
    Object object;
    String methodName;

    public ExMethod(Object object, String methodName) {
        this.object = object;
        this.methodName = methodName;
    }

    /**
     * @param proxy  代理对象的引用
     * @param method 当前执行的方法
     * @param args   当前执行的方法的参数
     * @return 和被代理对象方法有相同返回值类型
     * @throws Throwable

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我被 " + method + " 方法调用了,参数是 " + Arrays.toString(args));
        //返回值

        return method.invoke(object, args);
    }
}*/