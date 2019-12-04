package com.yuan.dp.builder;

import com.yuan.dp.builder.domain.Car;

/**
 * @author Yuan-9826
 */
public class BuilderTest {
    public static void main(String[] args) {
        //实际建造者 new
        CarBuilder carBuilder = new CarBuilderImpl_2();
        //建造指挥者 new
        CarDirector carDirector = new CarDirector(carBuilder);
        Car car = carDirector.carConductor();

    }
}
