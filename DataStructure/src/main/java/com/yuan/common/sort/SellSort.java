package com.yuan.common.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author Yuan-9826
 */
public class SellSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 6, 0, 1, 6, 1, 2, 3, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        //      shellAsc(arr);
        shellEXAsc(arr);
        System.out.println("-----------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------------------");
        //       shellDesc(arr);
               shellEXDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔换位升序排序
     *
     * @param arr
     */
    public static void shellAsc(int[] arr) {
        //第一层 分组
        for (int grp = arr.length / 2; grp > 0; grp /= 2) {
            //第二层 遍历最后一组元素
            for (int i = grp; i < arr.length; i++) {
                //根据上一层 遍历当前每组元素
                for (int j = i - grp; j >= 0; j -= grp) {
                    //如果前面的元素>后面的元素就交换
                    if (arr[j] > arr[grp + j]) {
                        arr[j] = arr[j] ^ arr[grp + j];
                        arr[grp + j] = arr[j] ^ arr[grp + j];
                        arr[j] = arr[j] ^ arr[grp + j];
                    }
                }
            }
        }

    }

    /**
     * 希尔换位降序排序
     *
     * @param arr
     */
    public static void shellDesc(int[] arr) {
        //第一层 分组
        for (int grp = arr.length / 2; grp > 0; grp /= 2) {
            //第二层 遍历最后一组元素
            for (int i = grp; i < arr.length; i++) {
                //根据上一层 遍历当前每组元素
                for (int j = i - grp; j >= 0; j -= grp) {
                    //如果前面的元素>后面的元素就交换
                    if (arr[j] < arr[grp + j]) {
                        arr[j] = arr[j] ^ arr[grp + j];
                        arr[grp + j] = arr[j] ^ arr[grp + j];
                        arr[j] = arr[j] ^ arr[grp + j];
                    }
                }
            }
        }
    }

    /**
     * 希尔插入升序排序
     *
     * @param arr
     */
    public static void shellEXAsc(int[] arr) {
        //第一层 分组
        for (int grp = arr.length / 2; grp > 0; grp /= 2) {
            //第二层 从最后一组开始遍历
            for (int i = grp; i < arr.length; i++) {
                int j = i;
                int left = arr[j];
                if (arr[j - grp] > arr[j]) {
                    while (j - grp >= 0 && left < arr[j - grp]) {
                        arr[j] = arr[j-grp];
                        j -= grp;
                    }
                    arr[j] = left;
                }
            }
        }
    }

    /**
     * 希尔插入降序排序
     *
     * @param arr
     */
    public static void shellEXDesc(int[] arr) {
        //第一层 分组
        for (int grp = arr.length / 2; grp > 0; grp /= 2) {
            //第二层 从最后一组开始遍历
            for (int i = grp; i < arr.length; i++) {
                int j = i;
                int left = arr[j];
                if (arr[j - grp] < arr[j]) {
                    while (j - grp >= 0 && left > arr[j - grp]) {
                        arr[j] = arr[j-grp];
                        j -= grp;
                    }
                    arr[j] = left;
                }
            }
        }
    }
}
