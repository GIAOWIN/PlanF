package com.yuan.util.annotation;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author Yuan-9826
 */
public class NotNullAnnotation {
    static {
        System.out.println("NotNullAnnotation");
    }

    /**
     * 获取所有类
     */
    private static List<Class> beasns = ScanClass.getBeasns();



    /**
     * 获得要代理的类和方法Map
     *
     *
     * @return要代理的类和方法Map 对象
     */
    public static HashMap<Class, ArrayList<Method>> getProxyMap() {
        HashMap<Class, ArrayList<Method>> proxyMap = new HashMap<>();
        for (Class beasn : beasns) {
            Method[] methods = beasn.getMethods();
            /**
             * 每个类中有目标注解的方法集合
             */
            ArrayList<Method> targetMethodList = new ArrayList<>();

            for (Method method : methods) {
                if (method.isAnnotationPresent(NotNull.class)) {

                    targetMethodList.add(method);
                }
            }
            //如果这个类有目标方法 就添加，没有就不添加
            if (targetMethodList.size() > 0) {
                proxyMap.put(beasn, targetMethodList);
            }

        }
        return proxyMap;


    }







 /*   public static void getAnnoMethod() {
        //1.遍历所有类
        for (Class bean : beasns) {
            //2.把有方法含有@NotNull 注解的方法都找出来
            Method[] mathods = bean.getDeclaredMethods();
            //2.1遍历每个类中的所有方法
            for (Method method : mathods) {
                //2.2如果有目标注解就获取
                NotNull annotation = method.getAnnotation(NotNull.class);
                if (method.isAnnotationPresent(NotNull.class)) {
                    System.out.println("有这个注解的方法是： = " + method);
                    *//**
     * 使用Cglib动态获取这些类传入的参数值
     * 1.Enhancer的creat方法
     *      creat方法中的参数是 被代理类的字节码对象，Callback接口，这里我用 new MethodInterceptor（）匿名的lambda表达式
     * 2.被代理类不能被final修饰
     *//*
                    Object exObj = Enhancer.create(bean, new MethodInterceptor() {
                        @Override
                        *//**
     * proxy 增强对象
     * method 截获的方法
     * args 参数数组
     * methodProxy 用于调用super（非截获方法）；可以根据需要多次调用
     *//*
                        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                            Object invoke = method.invoke(args);*/
              /*              boolean exec = true;
                            //数组中有就只检查数组中的参数
                            if (annotation.parameter().length > 0) {
                                Parameter[] parameters = method.getParameters();
                                //遍历方法参数的值
                                for (int i = 0; i < parameters.length; i++) {
                                    //遍历注解数组中的值
                                    for (String parameterName : annotation.parameter()) {
                                        //有一致的就检查是否为空
                                        if (parameterName.equals(parameters[i])) {
                                            if (args[i] == null) {
                                                System.out.println(parameterName + "传来的值是空的");
                                                exec = false;
                                            }
                                        }
                                    }
                                }
                                //数组中没有就检查value中的参数
                            } else {
                                if (annotation.value().length() > 0) {
                                    Parameter[] parameters = method.getParameters();
                                    //遍历方法参数的值
                                    for (int i = 0; i < parameters.length; i++) {
                                        //有和value一致的就检查是否为空
                                        if (annotation.value().equals(parameters[i])) {
                                            if (args[i] == null) {
                                                System.out.println(annotation.value() + "传来的值是空的");
                                                exec = false;
                                            }
                                            //value中也没有就检查全部参数
                                        }
                                    }
                                } else {
                                    for (int i1 = 0; i1 < args.length; i1++) {
                                        if (args[i1] == null) {
                                            System.out.println(args[i1] + "传来的值是空的");
                                            exec = false;
                                        }
                                    }
                                }
                            }
                            Object prox = null;
                            if (exec) {
                                prox = method.invoke(args);
                            }
                            return prox;*/
//                            return invoke;
//                        }
//                    });
//
//                }
//            }
//        }
//    }


}
