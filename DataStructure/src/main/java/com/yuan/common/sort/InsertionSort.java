package com.yuan.common.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author Yuan-9826
 */

public class InsertionSort {

    public static void insertAsc(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            //左边的数组序数是arr[0-i) 每次遍历完扩容为 [0-i]
            //遍历有序数组
            for (int j = 0; j < i; j++) {
                //定义要插入左边的元素left
                int left = arr[i];
                    //如果有这个数小那就插在arr[j]前面
                if (arr[i] <= arr[j]) {
                    //这个数后面元素后移 腾出一个位置
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    //将要插入有序数组一边的数插进去
                    arr[j] = left;
                }
            }
        }
    }

    public static void selectDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //左边的数组序数是arr[0-i) 每次遍历完扩容为 [0-i]
            //遍历有序数组
            for (int j = 0; j < i; j++) {
                int left = arr[i];
                if (arr[i] >= arr[j]) {
                    //说明这个数小那就插在arr[j]前面
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    //将要插入有序数组一边的数插进去
                    arr[j] = left;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 6, 0, 1, 6, 1, 2, 3, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        insertAsc(arr);
        System.out.println("-----------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------");
         selectDesc(arr);
        System.out.println(Arrays.toString(arr));
    }
}



