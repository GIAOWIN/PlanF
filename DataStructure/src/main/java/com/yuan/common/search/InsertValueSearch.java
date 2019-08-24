package com.yuan.common.search;

import java.util.Arrays;

/**
 * 插值查找
 *
 * @author Yuan-9826
 */
public class InsertValueSearch {
    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));
        int i = insertValueSearch(arr, 0, arr[arr.length - 1], 7);
        System.out.println("i = " + i);
    }

    /**
     * @param arr    目标数组
     * @param left   最左值
     * @param right  最右值
     * @param target 查找目标
     * @return 查找目标的下标
     */
    public static int insertValueSearch(int[] arr, int left, int right, int target) {

        //保证得到的mid不会引发数组下标越界
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (target > midVal) {
            return insertValueSearch(arr, mid, right, target);
        } else if (target < midVal) {
            return insertValueSearch(arr, left, mid, target);
        } else {
            return mid;
        }

    }

}
