package com.yuan.test;

import com.yuan.commons.CommonUtils;
import org.junit.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class EasyUtuilsTest {

    @Test
    public void uuidTest() {
        final String uuid = CommonUtils.uuid();
        System.out.println("uuid = " + uuid);
        //uuid = 3CA463D3B21E46179A25157E8A80BF2A
        uuid.notify();
    }

    @Test
    public void tempTest() {
        System.out.println(Math.round(-1.6));
        final ExecutorService cachedPool = Executors.newCachedThreadPool();
        final ExecutorService executorService = Executors.newFixedThreadPool(1);
        final ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(1);
        final ExecutorService singledPool = Executors.newSingleThreadExecutor();

    }
/**
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */

}
