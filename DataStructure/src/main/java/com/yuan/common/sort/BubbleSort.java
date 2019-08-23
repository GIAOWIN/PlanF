package com.yuan.common.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序 正序
     *
     * @param arr
     * @return
     */
    public static void bubbleAsc(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
            }
        }
    }

    /**
     * 冒泡排序 逆序
     * @param arr
     */
    public static void bubbleDesc(int[] arr) {

        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        bubbleAsc(arr);
        System.out.println("-----------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------");
        bubbleDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

}
