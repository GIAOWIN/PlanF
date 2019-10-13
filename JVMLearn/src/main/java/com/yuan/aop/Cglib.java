package com.yuan.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Yuan-9826
 */
public class Cglib {
    public static void main(String[] args) {
        /**
         * 使用Cglib动态获取这些类传入的参数值
         * 1.Enhancer的creat方法
         *      creat方法中的参数是 被代理类的字节码对象，
         *      Callback接口，这里我用 new MethodInterceptor（）匿名的lambda表达式
         * 2.被代理类不能被final修饰
         */
        Person person = new Person(1025,"yuan");
        System.out.println("------------------------");
        Person proxy = (Person)Enhancer.create(Person.class, new ExMethod(person));
        proxy.eat("土豆");
/*        proxy.getId();
        Object[] obj = {"蒸熊掌","蒸鹿邑","烧雏鸡",20,"馒头"};
        proxy.eat("yuan",obj);*/
    }
}

class ExMethod implements MethodInterceptor {
    private Person person;

    public ExMethod(Person person) {
        this.person = person;
    }

    /**
     * @param proxy       增强对象
     * @param method      截获的方法
     * @param args     参数数组
     * @param methodProxy
     * @return 用于调用super（非截获方法）；可以根据需要多次调用
     * @throws Throwable
     */
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.print("本方法名为: "+method.getName()+"\t\t");
        for (Object arg : args) {
            System.out.print("参数的值为: " +arg);
        }
        System.out.println();
        System.out.println("---------------------");
        Object invoke = method.invoke(person, args);
        return invoke;
    }
}
