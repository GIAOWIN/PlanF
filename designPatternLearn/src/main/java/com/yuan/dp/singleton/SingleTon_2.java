package com.yuan.dp.singleton;

/**
 * 测试类
 */
class Test_SingleTon_2 {
    public static void main(String[] args) {
        SingleTon_2 ton_1 = SingleTon_2.getSingleTon_2();
        SingleTon_2 ton_2 = SingleTon_2.getSingleTon_2();
        System.out.println(ton_1 == ton_2);
    }
}


public class SingleTon_2 {
    /**
     * 1.单利模式 防止其他类中new，所以private修饰
     */
    private SingleTon_2() {
    }

    /**
     * 2.类中创建对象----但是要在静态代码块中创建
     * 这里要说一下final，作用是不允许被修改变量的值，能修改值的时机是静态代码块以及有参构造加载时。
     *
     */
    private static final SingleTon_2 singleTon_2;

    static {
        singleTon_2 = new SingleTon_2();

    }

    /**
     * 3.对外提供一个静态方法来创建对象
     *
     * @return singleTon_2实例
     */
    public static SingleTon_2 getSingleTon_2() {
        return singleTon_2;
    }
}
