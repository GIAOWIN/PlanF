package com.yuan.common.search;

/**
 * 线性查找
 *
 * @author Yuan-9826
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 0, 2, 3, 4, 5, 6};

        System.out.println(seqSearch(arr,1));
    }

    /**
     * 找到一个满足条件的值，就返回下标,没找到返回-1
     *
     * @param arr 目标数组
     * @param target 查找目标
     * @return 查找目标的下标
     */
    public static int seqSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;

    }
}
