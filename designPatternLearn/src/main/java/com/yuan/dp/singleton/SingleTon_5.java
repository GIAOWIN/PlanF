package com.yuan.dp.singleton;

/**
 * 测试类 其实应该用多线程来测试的这里测试 毫无意义，有点强迫症的感觉。
 */
class Test_SingleTon_5 {
    public static void main(String[] args) {
        SingleTon_5 ton_1 = SingleTon_5.getSingleTon_5();
        SingleTon_5 ton_2 = SingleTon_5.getSingleTon_5();
        System.out.println(ton_1 == ton_2);
    }
}
/**
 * 单利模式-懒汉式-双重检查
 */
public class SingleTon_5 {
    /**
     * 1.单利模式 防止其他类中new，所以private修饰
     */
    private SingleTon_5() {
    }


    /**
     * 2.类中创建私有对象volatile修饰
     */
    private static volatile SingleTon_5 singleTon_5 = null;

    /**
     * 3.对外提供一个静态方法来创建对象
     *
     * @return singleTon_5实例
     * 相较于前一版多加了个synchronized
     */
    public static SingleTon_5 getSingleTon_5() {
        //非常优秀的逻辑处理，解决了多线程问题的同时又一定程度上解决了安全问题。
        if (singleTon_5 == null) {
            synchronized (SingleTon_5.class){
                if(singleTon_5 == null){
                    singleTon_5 = new SingleTon_5();
                }
            }
        }
        return singleTon_5;
    }
}

