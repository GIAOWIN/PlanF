package com.yuan.aop.cglib;

public class TestCglib {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new Person());

        Person pxPerson = (Person) factory.create();


        pxPerson.show("qqq", 321, null, "www");

    }
}
