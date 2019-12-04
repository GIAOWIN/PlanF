package com.yuan.dp.prototype;

import com.yuan.dp.prototype.domain.Friend;
import com.yuan.dp.prototype.domain.Sheep;

/**
 * 浅拷贝 只拷贝了属性的值
 *
 * @author Yuan-9826
 */
public class Prototype_1 {
    public static void main(String[] args) {
        Friend friend = new Friend();
        Sheep sheep_1 = new Sheep("喜羊羊", "白色", friend);
        System.out.println("sheep_1 = " + sheep_1);
        //sheep_1 = Sheep{name='喜羊羊', color='白色', friend='42121758'}
        Sheep sheep_2 = sheep_1.clone();
        System.out.println("sheep_2 = " + sheep_2);
        //sheep_2 = Sheep{name='喜羊羊', color='白色', friend='42121758'}
        System.out.println(sheep_1 == sheep_2);
        //false

    }
}
