package com.yuan.common.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,5,6,1, 2, 3};
        int[] bubble = bubble(arr);
        System.out.println(arr==bubble);
    }

    public static int[] bubble(int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length-2; j++) {
                if(arr[j]>arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] =temp;
                }
            }
        }
        return arr;
    }
}
