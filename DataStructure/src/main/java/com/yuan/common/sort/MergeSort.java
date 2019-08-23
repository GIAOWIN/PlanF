package com.yuan.common.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author Yuan-9826
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 6, 0, 1, 6, 1, 2, 3, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];
        int[] temp2 = new int[arr.length];
        mergeAsc(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
        mergeDesc(arr, 0, arr.length - 1, temp2);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归分解数组 升序
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeAsc(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            //左递归分解
            mergeAsc(arr, left, mid, temp);
            //右递归分解
            mergeAsc(arr, mid + 1, right, temp);
            //合并数组
            mergeAsc(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并数组 升序
     * @param arr   要改变的数组
     * @param left  左边有序数组的初始索引
     * @param mid   中间索引
     * @param right 右边有序数组的索引
     * @param temp  辅助数组
     */
    private static void mergeAsc(int[] arr, int left, int mid, int right, int[] temp) {

        //第一步 准备条件
        //初始化i 左边有序序列的初始索引
        int l = left;
        //初始化j 右边有序序列的初始索引
        int r = mid + 1;
        //指向temp数组的索引
        int t = 0;

        //第二步 把temp数组的前半段，由小到大的有序虚填充(按照归并排序的规则)
        while (l <= mid && r <= right) {
            //如果左边有序序列的当前元素小于右边有序序列的当前元素就将左边的元素填充到temp中【反正就将小的元素填充到temp中】
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }

        //第三步 将剩余部分填充到一股脑填充到temp的后半段
        //将左边有剩余的部分填充到temp
        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        //将右边有剩余的部分填充到temp
        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }

        //第四步 将temp数组中排序过的部分复制到arr数组中
        t = 0;
        int tmpLft = left;
        while (tmpLft <= right) {
            arr[tmpLft] = temp[t];
            tmpLft++;
            t++;
        }

    }

    /**
     * 递归分解数组 降序
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeDesc(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            //左递归分解
            mergeDesc(arr, left, mid, temp);
            //右递归分解
            mergeDesc(arr, mid + 1, right, temp);
            //合并数组
            mergeDesc(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并数组 降序
     * @param arr   要改变的数组
     * @param left  左边有序数组的初始索引
     * @param mid   中间索引
     * @param right 右边有序数组的索引
     * @param temp  辅助数组
     */
    private static void mergeDesc(int[] arr, int left, int mid, int right, int[] temp) {

        //第一步 准备条件
        //初始化i 左边有序序列的初始索引
        int l = left;
        //初始化j 右边有序序列的初始索引
        int r = mid + 1;
        //指向temp数组的索引
        int t = 0;

        //第二步 把temp数组的前半段，由大到小的有序虚填充(按照归并排序的规则)
        while (l <= mid && r <= right) {
            //如果左边有序序列的当前元素大于右边有序序列的当前元素就将左边的元素填充到temp中【反正就将大的元素填充到temp中】
            if (arr[l] > arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }

        //第三步 将剩余部分填充到一股脑填充到temp的后半段
        //将左边有剩余的部分填充到temp
        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        //将右边有剩余的部分填充到temp
        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }

        //第四步 将temp数组中排序过的部分复制到arr数组中
        t = 0;
        int tmpLft = left;
        while (tmpLft <= right) {
            arr[tmpLft] = temp[t];
            tmpLft++;
            t++;
        }

    }

}
