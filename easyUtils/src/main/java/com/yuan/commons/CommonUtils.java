package com.yuan.commons;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

/**
 * @author Yuan-9826
 */
public class CommonUtils {
    /**
     * 生成不重复的32位长的大写字符串
     *
     * @return 不重复的32位长的大写字符串
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 把 map 转化成 JavaBean对象
     *
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(Map map, Class<T> clazz) {
        try {
            //1.创建指定类型的javaBean对象。
            T bean = clazz.newInstance();
            //2.把数据封装到JavaBean中
            BeanUtils.populate(bean, map);
            //3.返回bean对象
            return bean;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
