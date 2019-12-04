package com.yuan.dp.prototype;

import com.yuan.dp.prototype.domain.Chicken;
import com.yuan.dp.prototype.domain.Friend;

public class Prototype_3 {
    public static void main(String[] args) {

        Friend friend = new Friend();

        Chicken chicken_1 = new Chicken("小红", "睡觉", friend);
        System.out.println("chicken_1 = " + chicken_1);
        //chicken_1 = Chicken{name='小红', hobby='睡觉', friend=42121758}
        Chicken chicken_2 = chicken_1.clone();
        System.out.println("chicken_2 = " + chicken_2);
        //chicken_2 = Chicken{name='小红', hobby='睡觉', friend=1810132623}
        System.out.println(chicken_1 == chicken_2);
        //false
    }
}
