package com.yuan.dp.singleton;

/**
 * 单利模式-懒汉式-枚举
 * @author Yuan-9826
 */
enum SingleTon_7 {
    /**
     * 这是一个SingleTon_7类型的枚举值
     */
    INSTANCE
}

class Test_SingleTon_7{
    public static void main(String[] args) {
        /**
         * 结果为true毫无悬念【这种方式是Effective Java作者Josh Bloch 提倡的方式 】
         */
        System.out.println(SingleTon_7.INSTANCE==SingleTon_7.INSTANCE);

    }
}
