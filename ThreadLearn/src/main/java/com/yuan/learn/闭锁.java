package com.yuan.learn;

import java.util.concurrent.CountDownLatch;

public class 闭锁 {
    public static void main(String[] args) {
        final long start = System.currentTimeMillis();

        final CountDownLatch countDownLatch = new CountDownLatch(5);
        final LatchDemo latchDemo = new LatchDemo(countDownLatch);

        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }
        final long end = System.currentTimeMillis();

        System.out.println("耗时" + (end - start) + "毫秒");
    }
}

class LatchDemo implements Runnable {
    /**
     * 倒计时锁
     */
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 50000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            /**
             * 减少闩锁的计数，如果计数达到零，则释放所有等待的线程。如果当前计数大于零，则将其递减。
             * 如果新计数为零，则所有等待的线程都将重新启用以进行线程调度。
             * 如果当前计数等于零，则不会发生任何事情。
             */
            latch.countDown();
        }
    }
}