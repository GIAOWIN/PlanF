package com.yuan.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于cglib的代理对象工厂类
 *
 * @author Yuan-9826
 */
public class ProxyFactory {
    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public Object create() {
        MethodInterceptor exMethod = new MethodInterceptor() {
            /**
             * @param proxy         增强对象
             * @param method        截获的方法
             * @param args          参数数组
             * @param methodProxy   用于调用super（非截获方法）；可以根据需要多次调用
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                Object invoke = null;
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == null) {
                        System.out.println("第" + i + 1 + "个参数是null");
                        return null;
                    }
                }
                invoke = method.invoke(object, args);
                return invoke;
            }
        };

        /**
         * 使用Cglib动态获取这些类传入的参数值
         * 1.Enhancer的creat方法
         *      creat方法中的参数是 被代理类的字节码对象，
         *      Callback接口，这里我用 new MethodInterceptor（）匿名的lambda表达式
         * 2.被代理类不能被final修饰
         */
        Object proxy = Enhancer.create(object.getClass(), exMethod);
        return proxy;
    }
}
