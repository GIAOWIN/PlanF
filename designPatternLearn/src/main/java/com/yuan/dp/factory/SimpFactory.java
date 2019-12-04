package com.yuan.dp.factory;

/**
 * 简单工厂模式【专门用来生产对象的类】
 *
 * @author Yuan-9826
 */
public class SimpFactory<T> {

    private SimpFactory() {
    }


    /**
     * 获取工厂类实例对象
     *
     * @return
     */
    static SimpFactory createSimpFactory() {

        return new SimpFactory();
    }

    /**
     * 根据简单的类名获取类实例对象
     * @param name 同级别目录下的类名 简单乱写的一个方法只做参考用
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    T getProxy(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = "com.yuan.dp.factory." + name;
        Class<T> aClass = (Class<T>) Class.forName(className);
        T proxy = aClass.newInstance();
        return proxy;
    }

    @Override
    public String toString() {
        return "SimpFactory{" +
                '}';
    }


}
