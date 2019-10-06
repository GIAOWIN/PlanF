package com.yuan.learn;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 1.不具备“互斥性”。
 * 2.不保证“原子性”。
 * 3.保证共享数据在缓存中的可见性，相较于synchronized是一种较为轻量级的同步策略。
 * @author Yuan-9826
 */
public class VolatileL {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[55]);
    }
}
