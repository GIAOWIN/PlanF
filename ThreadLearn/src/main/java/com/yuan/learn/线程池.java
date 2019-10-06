package com.yuan.learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class 线程池 {
    public static void main(String[] args) {


        /**
         * 创建缓存线程池 池中线程数量不固定，因需变化
         */
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        /**
         * 创建固定(线程数)大小的线程池
         */
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        /**
         * 创建单个线程的线程池(池中只有一个线程)
         */
        ExecutorService singledPool = Executors.newSingleThreadExecutor();
        /**
         * 创建固定大小的线程池，可以延迟或者定时执行任务
         */
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(1);
    }
}

class ScheduledPoolDemo {
    public static void main(String[] args) {

        //创建固定大小的线程池，可以延迟或者定时执行任务
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        //参数：任务，数字，数字单位
        pool.schedule(new Task(),1, TimeUnit.SECONDS);
        pool.schedule(new Task(),1, TimeUnit.SECONDS);
        pool.schedule(new Task(),1, TimeUnit.SECONDS);
        pool.schedule(new Task(),1, TimeUnit.SECONDS);
        pool.schedule(new Task(),1, TimeUnit.SECONDS);
        //温和关闭线程
        pool.shutdown();

    }

}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : " + (int) (Math.random() * 101));
    }
}