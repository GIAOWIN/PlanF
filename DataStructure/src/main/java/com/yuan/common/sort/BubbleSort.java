package com.yuan.common.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 从小到大排序【改变传入数组】
     *
     * @param arr
     * @return
     */
    public static int[] bubble(int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 2; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
