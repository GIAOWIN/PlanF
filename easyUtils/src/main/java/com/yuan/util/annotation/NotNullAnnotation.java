package com.yuan.util.annotation;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Yuan-9826
 */
public class NotNullAnnotation implements ChickNull {

    private static List<Class> beasns = ScanClass.getBeasns();

    public static void getAnnoMethod() {
        ArrayList<Method> methods = new ArrayList<>();
        //1.遍历所有类
        for (Class bean : beasns) {
            //2.把有方法含有@NotNull 注解的方法都找出来
            Method[] mathods = bean.getDeclaredMethods();
            //2.1遍历每个类中的所有方法
            for (Method method : mathods) {
                //2.2如果有目标注解就获取
                NotNull annotation = method.getAnnotation(NotNull.class);

                if (method.isAnnotationPresent(NotNull.class)) {
                    /**
                     * 使用Cglib动态获取这些类传入的参数值
                     * 1.Enhancer的creat方法
                     *      creat方法中的参数是 被代理类的字节码对象，Callback接口，这里我用 new MethodInterceptor（）匿名的lambda表达式
                     * 2.被代理类不能被final修饰
                     */
                    Object exObj = Enhancer.create(bean, new MethodInterceptor() {
                        @Override
                        /**
                         * proxy 增强对象
                         * method 截获的方法
                         * args 参数数组
                         * methodProxy 用于调用super（非截获方法）；可以根据需要多次调用
                         */
                        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                            boolean exec = true;
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
                            return prox;
                        }
                    });

                }
            }
        }
    }

    @Override
    public void chick(ArrayList<Method> methodss) throws Exception {
        System.out.println("没增强的Check");

    }


}
