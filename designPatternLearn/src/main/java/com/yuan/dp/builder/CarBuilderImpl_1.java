package com.yuan.dp.builder;

/**
 * 功能：提供构建产品的具体材料
 * 角色：实际建造者(1号)
 * 南孚电池+悍马品牌
 *
 * @author Yuan-9826
 */
public class CarBuilderImpl_1 extends CarBuilder {
    @Override
    public void buildBrand() {
        System.out.println("给小汽车加了HM品牌");

    }

    @Override
    public void buildBattery() {
        System.out.println("给小汽车加了NF电池");
    }
}

