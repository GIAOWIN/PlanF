package com.yuan.dp.prototype.domain;

/**
 * 实体类 绵羊
 *
 * @author Yuan-9826
 */
public class Sheep implements Cloneable {
    private String name;

    private String color;

    private Friend friend;

    public Sheep() {

    }

    public Sheep(String name, String color, Friend friend) {
        this.name = name;
        this.color = color;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Friend getFirSheep() {
        return friend;
    }

    public void setWeight(Friend friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", friend='" + friend.hashCode() + '\'' +
                '}';
    }

    /**
     * 浅拷贝使用默认方法 记得要强转类型  不然调用的时候就要强转 同理也要try catch
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Sheep clone() {

        Sheep clone = null;
        try {
            clone = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
