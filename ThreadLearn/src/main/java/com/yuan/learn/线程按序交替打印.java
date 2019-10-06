package com.yuan.learn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 线程按序交替打印 {
    public static void main(String[] args) {
        final AlternateDamo ad = new AlternateDamo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopA(i);
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopB(i);
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopC(i);
                }
            }
        }, "C").start();
    }
}

class AlternateDamo {
    /**
     * 当前线程的标记
     */
    private String sign = "A";
    /**
     * 重入锁
     */
    private Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    /**
     * 打印A线程
     */
    public void loopA(int totalloop) {
        lock.lock();
        try {
            //1.判断
            if (!"A".equals(sign)) {
                conditionA.await();
            }
            //2.打印
//            for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + "" + "\t" + totalloop);
//            }
            //3.唤醒
            sign = "B";
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印B线程
     */
    public void loopB(int totalloop) {
        lock.lock();
        try {
            //1.判断
            if (!"B".equals(sign)) {
                conditionB.await();
            }
            //2.打印
//            for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + "" + "\t" + totalloop);
//            }
            //3.唤醒
            sign = "C";
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 打印C线程
     */
    public void loopC(int totalloop) {
        lock.lock();
        try {
            //1.判断
            if (!"C".equals(sign)) {
                conditionC.await();
            }
            //2.打印
//            for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + "" + "\t" + totalloop);
//            }
            //3.唤醒
            sign = "A";
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}