package com.yuan.dp.builder.domain;

/**
 * 功能：提供产品的具体属性和get、set方法。
 * 角色：产品
 */
public class Car {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 电池
     */
    private String battery;

    public Car() {
    }

    public Car(String brand, String battery) {
        this.brand = brand;
        this.battery = battery;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", battery='" + battery + '\'' +
                '}';
    }
}
