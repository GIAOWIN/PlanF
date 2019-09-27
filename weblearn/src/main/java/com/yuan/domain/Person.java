package com.yuan.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 实体类
 * @author Yuan-9826
 */
public class Person implements HttpSessionBindingListener {

    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("我被添加到Session中啦");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("我被Session给移除掉啦");

    }
}
