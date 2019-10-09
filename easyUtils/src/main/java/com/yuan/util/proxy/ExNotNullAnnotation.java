package com.yuan.util.proxy;

import com.yuan.util.annotation.ChickNull;
import com.yuan.util.annotation.NotNullAnnotation;

import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 * 增强检查方法
 *
 * @author Yuan-9826
 */
public class ExNotNullAnnotation {


    public static void main(String[] args) throws Exception {
        //1.创建真实对象
        NotNullAnnotation notNullAnnotation = new NotNullAnnotation();

        //2.创建动态代理对象
        /**
         * ClassLoader loader, 被代理类的类加载器
         * Class<?>[] interfaces,被代理类的接口
         * InvocationHandler h，处理器
         */
        ChickNull proxy_check = (ChickNull) Proxy.newProxyInstance(
                notNullAnnotation.getClass().getClassLoader()
                , notNullAnnotation.getClass().getInterfaces()
                , (proxy, method, argss) -> {

                    //使用真实对象调用方法
                    System.out.println(Arrays.toString(argss));
                    method.invoke(notNullAnnotation,argss);
                    System.out.println("增强了的Check");
                    return null;
                }
        );


        //3.调用方法
//        proxy_check.chick(NotNullAnnotation.getAnnoMethod());
    }
}
