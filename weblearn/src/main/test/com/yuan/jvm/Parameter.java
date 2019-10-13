package com.yuan.jvm;

public class Parameter {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //cpu 逻辑核数
        int cup = runtime.availableProcessors();
        System.out.println(cup);
        //Java试图使用的最大内存
        long maxMemory = runtime.maxMemory();
        System.out.println("-Xmx:MAX_MEMORY = " + maxMemory+" (字节) " + (maxMemory/(double)1024/1024) + "MB");
        //JVM 占用的内存总量
        long totalMemory = runtime.totalMemory();
        System.out.println("-Xms:TOTAL_MEMORY = " + totalMemory+" (字节) " + (totalMemory/(double)1024/1024) + "MB");

    }
}
