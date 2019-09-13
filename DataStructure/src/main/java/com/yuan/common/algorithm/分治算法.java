package com.yuan.common.algorithm;

public class 分治算法 {
    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只移动一个
        if(num==1){
            //A移动到C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
        }else {
            //如果移动多个
            //a先移动到b
            hanoiTower(num-1,a,c,b);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //然后移动到c
            hanoiTower(num-1,b,a,c);
        }
    }

}
