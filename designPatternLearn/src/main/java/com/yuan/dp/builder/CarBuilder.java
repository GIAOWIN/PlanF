package com.yuan.dp.builder;

import com.yuan.dp.builder.domain.Car;

/**
 * 功能：定义成品需要的材料
 * 角色：抽象建造者
 *
 * @author Yuan-9826
 */
public abstract class CarBuilder {
    Car car = new Car();

    /**
     * 构建品牌
     */
    public abstract void buildBrand();

    /**
     * 构建电池
     */
    public abstract void buildBattery();

    /**
     * 假设这辆车 有品牌 有驱动力就可以出厂了
     */
    public Car buildCar() {
        return car;
    }

}
