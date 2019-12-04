package com.yuan.dp.singleton;

/**
 * 测试类
 */
class Test_SingleTon_4 {
    public static void main(String[] args) {
        SingleTon_4 ton_1 = SingleTon_4.getSingleTon_4();
        SingleTon_4 ton_2 = SingleTon_4.getSingleTon_4();
        System.out.println(ton_1 == ton_2);
    }
}

/**
 * 单利模式-懒汉式-入门
 */
public class SingleTon_4 {
    /**
     * 1.单利模式 防止其他类中new，所以private修饰
     */
    private SingleTon_4() {
    }


    /**
     * 2.类中创建私有对象
     */
    private static SingleTon_4 singleTon_4 = null;

    /**
     * 3.对外提供一个静态方法来创建对象
     *
     * @return singleTon_4实例
     * 相较于前一版多加了个synchronized
     */
    public synchronized static SingleTon_4 getSingleTon_4() {
        //这里是精华，使用到了懒加载，其实优化代码就是尽量懒加载，不过懒加载也要视情况而定。
        if (singleTon_4 == null) {
            singleTon_4 = new SingleTon_4();
        }
        return singleTon_4;
    }
}
