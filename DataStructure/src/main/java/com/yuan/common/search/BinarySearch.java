package com.yuan.common.search;


/**
 * 二分查找
 *
 * @author Yuan-9826
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        System.out.println(arr[binarySerch(arr, 0, arr.length - 1, target)]==target);
    }

    /**
     * @param arr 目标数组
     * @param left 最左值
     * @param right 最右值
     * @param target 查找目标
     * @return 查找目标的下标
     */
    public static int binarySerch(int[] arr, int left, int right, int target) {
        //防止内存溢出
        if (left > right) {
            return -1;
        }
        //中 下标
        int middle = (right + left) / 2;
        //中 值
        int middleValue = arr[middle];

        if (target > middleValue) {
            //右递归
            return binarySerch(arr, middle, right, target);
        } else if (target < middleValue) {
            //左递归
            return binarySerch(arr, left, middle, target);
        } else {
            //返回下标
            return middle;
        }
    }


}
