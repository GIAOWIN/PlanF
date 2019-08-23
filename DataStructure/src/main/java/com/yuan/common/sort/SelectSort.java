package com.yuan.common.sort;

import java.util.Arrays;

public class SelectSort {

    /**
     * 选择排序 升序
     *
     * @param arr
     */
    public static void selectAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //记录最小值坐标和值
            int minValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    minValue = arr[j];
                    arr[j] = arr[i];
                    arr[i] = minValue;
                }
            }
        }
    }

    /**
     * 选择排序 降序
     *
     * @param arr
     */
    private static void selectDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //记录最大值坐标和值
            int minValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    minValue = arr[j];
                    arr[j] = arr[i];
                    arr[i] = minValue;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        selectAsc(arr);
        System.out.println("-----------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------");
        selectDesc(arr);
        System.out.println(Arrays.toString(arr));
    }
}