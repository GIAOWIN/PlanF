package com.yuan.dp.prototype;

import com.yuan.dp.prototype.domain.Friend;
import com.yuan.dp.prototype.domain.People;

/**
 * 深拷贝 拷贝
 *
 * @author Yuan-9826
 */
public class Prototype_2 {
    public static void main(String[] args) {
        Friend friend = new Friend();
        People yuan_1 = new People("yuan", 18, friend);
        System.out.println("yuan_1 = " + yuan_1);
        //yuan_1 = People{name='yuan, age=18, friend=42121758}
        People yuan_2 = yuan_1.clone();
        System.out.println("yuan_2 = " + yuan_2);
        //yuan_2 = People{name='yuan, age=18, friend=20671747}
        System.out.println(yuan_1 == yuan_2);
        //false

    }
}
