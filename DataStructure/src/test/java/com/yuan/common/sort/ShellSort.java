package com.yuan.common.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] ints = shellSort(arr);
    }

    public static int[] shellSort(int[] arr) {
        //第一层Shell分组 分成几组循环几次 length/2
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //第二层 分成gap组
            for (int i = gap; i < arr.length; i++) {
                //第三层 遍历每组元素 步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        arr[j] = arr[j] ^ arr[j + gap];
                        arr[j + gap] = arr[j] ^ arr[j + gap];
                        arr[j] = arr[j] ^ arr[j + gap];
                    }
                }
                System.out.println(Arrays.toString(arr));
                System.out.println("----------1----------");
            }
            System.out.println("----------2----------");
        }
        System.out.println("----------3----------");
        return arr;
    }

    /**
     * 对交换式的希尔排序进行优化->移位法
     * @param arr
     */
    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }

}
