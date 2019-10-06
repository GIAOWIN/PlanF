package com.yuan.learn;

import java.util.concurrent.*;

public class 同步容器类 {
    public static void main(String[] args) {
        final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
        final ConcurrentSkipListSet  <String> strings = new ConcurrentSkipListSet<String>();
        final ConcurrentSkipListMap  <String, Object> cmap = new ConcurrentSkipListMap<String, Object>();
        final CopyOnWriteArrayList  <String> list = new CopyOnWriteArrayList<String>();
        final CopyOnWriteArraySet  <String>  set = new CopyOnWriteArraySet<String>();
        //，
        //。
    }
}
