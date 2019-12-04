package com.yuan.dp.builder;

import com.yuan.dp.builder.domain.Car;

/**
 * 功能：提供构建产品的顺序
 * 角色：指挥者
 * @author Yuan-9826
 */
public class CarDirector {

    CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }
    /**
     * 以怎样的顺序构建CarBuilder，交给指挥者方法
     * 动态指定构建流程
     */
    public Car carConductor(){
        //先赋予品牌
        carBuilder.buildBrand();
        //再赋予电池
        carBuilder.buildBattery();
        return carBuilder.buildCar();
    }
}
