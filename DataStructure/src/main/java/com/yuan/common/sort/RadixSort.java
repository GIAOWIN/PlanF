package com.yuan.common.sort;


import java.util.Arrays;

/**
 * 基数排序
 * 降序排序搞不出来QAQ  关键应该在第二步第三步  不过就是没搞出来
 * @author Yuan-9826
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixAsc(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixAsc(int[] arr) {

        //创建桶数组
        int[][] bucket = new int[10][arr.length];
        //这个数组存储每个桶中的元素的数量
        int[] countArr = new int[10];
        //最大数字的位数，也是循环次数
        int length = length(arr);
        //第一步 确定循环次数
        for (int a = 0, n = 1; a < length; a++, n *= 10) {

            //第二步 将数据按照排序规律放到桶中
            for (int i = 0; i < arr.length; i++) {
                //每次参考的位置上的数
                int position = arr[i] / n % 10;
                //放到对应的桶中的对应的位置
                bucket[position][countArr[position]] = arr[i];
                //指针下移一位
                countArr[position]++;
            }

            //第三步 取出桶里的元素放到原来的数组
            int index = 0;
            for (int x = 0; x < bucket.length; x++) {
                if (countArr[x] != 0) {
                    for (int y = 0; y < countArr[x]; y++) {
                        arr[index++] = bucket[x][y];
                    }
                }
                //取出之后清空记录
                countArr[x] = 0;
            }
        }


    }


    /**
     * 获取数组中位数最多的数字的位数
     *
     * @param arr
     * @return
     */
    public static int length(int[] arr) {
        int length = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                length = arr[i + 1];
            } else {
                length = arr[i];
            }
        }
        return String.valueOf(length).length();
    }
}
