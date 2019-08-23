package com.yuan.common.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author Yuan-9826
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, -5, 5, -6, 1, -6, 0, 1, -2, -3, 4, 8, 9};
//        int[] arr = {0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(arr));
        quickAsc(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序 升序 递归冒泡
     * @param arr
     * @param left
     * @param right
     */
    private static void quickAsc(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        System.out.println("中值是" + pivot + "下标是" + ((left + right) / 2));
        //l >= r 时代表操作完成
        while (l < r) {
            //得到一个应该在右区的数
            while (arr[l] < pivot) {
                l++;
            }
            //得到一个应该在左区的数
            while (arr[r] > pivot) {
                r--;
            }
            //如果这两个数下标一致就不用掉换
            if (l >= r) {
                break;
            }
//            到此为止,得到一大一小两个数【相对于pivote来说】使其交换
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];

//            如果交换完之后发现与pivot相等,那么前移一位l或者r
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }

            //避免死循环
            if (l == r) {
                l++;
                r--;
            }
            //向左递归
            if (left < r) {
                quickAsc(arr, left, r);
            }
            //向右递归
            if (right > l) {
                quickAsc(arr, l, right);
            }
        }
    }

    /**
     * 快速排序 降序 递归冒泡
     * @param arr
     * @param left
     * @param right
     */
    private static void quickDesc(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        System.out.println("中值是" + pivot + "下标是" + ((left + right) / 2));
        //l >= r 时代表操作完成
        while (l > r) {
            //得到一个应该在右区的数【👈区找小数】
            while (arr[l] > pivot) {
                l++;
            }
            //得到一个应该在左区的数【👉区找大数】
            while (arr[r] < pivot) {
                r--;
            }
            //如果这两个数下标一致就不用掉换
            if (l >= r) {
                break;
            }
//            到此为止,得到一大一小两个数【相对于pivote来说】使其交换
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];

//            如果交换完之后发现与pivot相等,那么前移一位l或者r
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }

            //避免死循环
            if (l == r) {
                l++;
                r--;
            }
            //向左递归
            if (left < r) {
                quickAsc(arr, left, r);
            }
            //向右递归
            if (right > l) {
                quickAsc(arr, l, right);
            }
        }
    }
}
