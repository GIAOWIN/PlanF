package com.yuan.dp.singleton;

/**
 * 单利模式-懒汉式-静态内部类
 *
 * @author Yuan-9826
 */
public class SingleTon_6 {
    /**
     * 1.构造私有化
     */
    private SingleTon_6() {
    }

    /**
     * 2.构建静态内部类
     */
    private static class InsideSingleTon_6 {
        private static final SingleTon_6 SINGLE_TON_6 = new SingleTon_6();
    }

    /**
     * 3.提供公共方法获取实例
     *  调用该方法时才会加载静态内部类
     * @return
     */
    public static SingleTon_6 getInstance() {
        return InsideSingleTon_6.SINGLE_TON_6;
    }
}
