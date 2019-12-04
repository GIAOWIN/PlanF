package com.yuan.dp.factory;

/**
 * 用来测试简单工厂的测试类
 *
 * @author Yuan-9826
 */
public class FactoryTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        SimpFactory simpFactory = SimpFactory.createSimpFactory();
        SimpProxy_1 simpProxy_1 = (SimpProxy_1) simpFactory.getProxy("SimpProxy_1");
        simpProxy_1.setBefore("设置前置方法");
        System.out.println("simpProxy_1 = " + simpProxy_1);
        SimpProxy_2 simpProxy_2 = (SimpProxy_2) simpFactory.getProxy("SimpProxy_2");
        simpProxy_2.setAfter("设后前置方法");
        System.out.println("simpProxy_2 = " + simpProxy_2);

    }
}
