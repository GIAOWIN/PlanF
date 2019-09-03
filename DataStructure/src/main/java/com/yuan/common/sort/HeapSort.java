package com.yuan.common.sort;

import java.util.Arrays;

/**
 * 利用二叉树进行堆排序Demo
 */
public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};


        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 编写一个堆排序的方法
     */
    public static void heapSort(int[] arr) {
        int temp = 0;

        //从下层往上层循环排序
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //循环将arr[0]放到最后升序排序
        for (int j = arr.length - 1; j > 0; j--) {
            //第一个数和最后一个数交换：最大的数去了最后arr[length-1],
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //将arr[0]到arr[length-2]区间筛选到arr[0]
            adjustHeap(arr, 0, j);
        }
    }


    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param lenght 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int lenght) {
        //temp 临时变量 赋值当前节点 【父节点】
        int temp = arr[i];

        //K当前节点的左子节点的下标  i = 0 就是从0开始
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            //右子节点存在 并且 左子节点小于右子节点---------k++
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                k++;
            }

            //如果左子节点>父节点---------左子节点替换父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        //父节点替换左子节点
        arr[i] = temp;
    }

}