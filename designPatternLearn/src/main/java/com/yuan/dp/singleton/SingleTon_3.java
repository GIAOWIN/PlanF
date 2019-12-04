package com.yuan.dp.singleton;

/**
 * 测试类
 */
class Test_SingleTon_3 {
    public static void main(String[] args) {
        SingleTon_3 ton_1 = SingleTon_3.getSingleTon_3();
        SingleTon_3 ton_2 = SingleTon_3.getSingleTon_3();
        System.out.println(ton_1 == ton_2);
    }
}

/**
 * 单利模式-懒汉式-极简
 */
public class SingleTon_3 {
    /**
     * 1.单利模式 防止其他类中new，所以private修饰
     */
    private SingleTon_3() {
    }


    /**
     * 2.类中创建私有对象
     */
    private static SingleTon_3 singleTon_3 = null;

    /**
     * 3.对外提供一个静态方法来创建对象
     *
     * @return singleTon_3实例
     */
    public static SingleTon_3 getSingleTon_3() {
        //这里是精华，使用到了懒加载，其实优化代码就是尽量懒加载，不过懒加载也要视情况而定。
        if (singleTon_3 == null) {
            singleTon_3 = new SingleTon_3();
        }
        return singleTon_3;
    }
}
