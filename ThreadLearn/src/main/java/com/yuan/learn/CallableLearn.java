package com.yuan.learn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableLearn {
    public static void main(String[] args) {
        final CallableDemo callableDemo = new CallableDemo();

        //1.需要FutureTask的支持，用于接收结果
        final FutureTask<Integer> futureTask = new FutureTask<Integer>(callableDemo);
        //2.执行
        new Thread(futureTask).start();
        try {
            //在2执行完之后才会执行 可以用于闭锁
            final Integer integer = futureTask.get();
            System.out.println("integer = " + integer);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableDemo implements Callable<Integer> {

    private int a = 0;

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 100; i++) {
            a += i;
        }
        return a;
    }
}


