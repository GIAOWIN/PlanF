package com.yuan.dp.builder;

/**
 * 功能：提供构建产品的具体材料
 * 角色：实际建造者(2号)
 *
 * @author Yuan-9826
 */
public class CarBuilderImpl_2 extends CarBuilder{
    @Override
    public void buildBrand() {
        System.out.println("给小汽车加了ADSZ品牌");

    }

    @Override
    public void buildBattery() {
        System.out.println("给小汽车加了PT电池");
    }
}
