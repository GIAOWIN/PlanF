package com.yuan.common.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Selec1tSort {

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 1, 2, 3};
        System.out.println(Arrays.toString(selectSort(arr)));;


    }

    /**
     * 从小到大排序
     *
     * @param arr
     */
    public static int[] selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            //记录最小值坐标和值
            int minCd = i;
            int minValue = arr[i];


            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]) {
                    minValue = arr[j];
                    minCd = j;
                }
            }

            //替换
           // if (minCd != i) {
                arr[minCd] = arr[i];
                arr[i] = minValue;
         //   }

        }
        return arr;
    }
}
/*

 */