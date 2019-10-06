package com.yuan.learn;

import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁 {
    public static void main(String[] args) {
        final RWDemo rwDemo = new RWDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwDemo.setNum((int) (Math.random() * 101));
            }
        }, "Write").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rwDemo.getNum();
                }
            }, "Read").start();

        }

    }
}

class RWDemo {
    int num = 0;
    ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读方法用读锁
     *
     * @return
     */
    public int getNum() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +" " + num);
        } finally {
            lock.readLock().unlock();
        }
        return num;
    }

    /**
     * 写方法用写锁
     *
     * @param num
     */
    public void setNum(int num) {
        lock.writeLock().lock();
        try {
            this.num = num;
            System.out.println(Thread.currentThread().getName() +" " + num);
        } finally {
            lock.writeLock().unlock();
        }
    }
}