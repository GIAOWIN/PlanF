package com.yuan.javabean;

import cn.wanghaomiao.xpath.util.CommonUtil;
import com.yuan.util.CommonUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


public class BeanTest {

    @Test
    /**
     *  设置Person对象属性
     */
    public void test1() throws Exception {
        String className = "com.yuan.javabean.Person";
        Class<?> clazz = Class.forName(className);
        Object bean = clazz.newInstance();

        BeanUtils.setProperty(bean, "name", "张三");
        BeanUtils.setProperty(bean, "age", "18");

        System.out.println("bean = " + bean);
        //bean = Person{name='张三', age=18}
    }

    @Test
    /**
     * 把Map中的属性放到Person对象中
     */
    public void test2() throws Exception {

        HashMap<String, String> personMap = new HashMap<>(1);
        personMap.put("name", "张三");
        personMap.put("age", "18");

        Person person = new Person();
        BeanUtils.populate(person, personMap);
        System.out.println("person = " + person);
        //person = Person{name='张三', age=18}
    }

    @Test
    /**
     * 用法 ：直接将表单数据添加到JavaBean中
     */
    public void test3() throws Exception {
        HashMap<String, String> personMap = new HashMap<>(1);
        personMap.put("name", "张三");
        personMap.put("age", "18");
        Person person = new Person();
        Person personBean = CommonUtils.toBean(personMap, person.getClass());
        System.out.println("personBean = " + personBean);
        //personBean = Person{name='张三', age=18}
    }
}