package com.yuan.aop.jdk;

public class ExTest {
    public static void main(String[] args) {
        ProxyFactory personProxyFactory = new ProxyFactory(new Person());
        Student person = (Student)personProxyFactory.createProxy();
        person.learn();
    }
}
