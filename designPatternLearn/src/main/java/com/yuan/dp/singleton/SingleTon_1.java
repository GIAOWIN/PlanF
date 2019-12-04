package com.yuan.dp.singleton;

/**
 * 测试类
 */
class Test_SingleTon_1 {
    public static void main(String[] args) {
        SingleTon_1 ton_1 = SingleTon_1.getSingleTon_1();
        SingleTon_1 ton_2 = SingleTon_1.getSingleTon_1();
        System.out.println(ton_1 == ton_2);
    }
}


/**
 * 单例模式-饿汉式-静态常量
 * @author Yuan-9826
 */
public class SingleTon_1 {

    /**
     * 1.单利模式 防止其他类中new，所以private修饰
     */
    private SingleTon_1() {
    }

    /**
     * 2.类中创建对象
     */
    private static final SingleTon_1 singleTon_1 = new SingleTon_1();

    /**
     * 3.对外提供一个静态方法来创建对象
     *
     * @return singleTon_1实例
     */
    public static SingleTon_1 getSingleTon_1() {
        return singleTon_1;
    }
}
