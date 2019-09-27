package com.yuan.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 本地线程
 */
public class ThreadLocal<T> {
    /**
     * 装线程的容器
     */
    private Map<Thread, T> map = new HashMap<>();

    /**
     * 设置一个线程
     *
     * @param data
     */
    public void setMap(T data) {
        map.put(Thread.currentThread(), data);
    }

    /**
     * 获取本地线程
     *
     * @return
     */
    public T getMap() {
        return map.get(Thread.currentThread());
    }

    /**
     * 移除本地线程
     */
    public void remove() {
        map.remove(Thread.currentThread());
    }
}
