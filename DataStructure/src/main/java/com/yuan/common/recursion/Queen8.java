package com.yuan.common.recursion;


import java.util.Arrays;

public class Queen8 {

    /**
     * 初始化棋子🚩数组
     */
    private static int count = 1;
    private static int max = 8;
    private static int[] arr = new int[max];

    /**
     * 放置棋子，并于第八个结束（从零开始）
     *
     * @param n
     */
    public static void place(int n) {
        if (n == 8) {
            print();
        } else {
            //每次放置时，先放到第一列，行则下一行。不行下一列
            for (int i = 0; i < 8; i++) {
                arr[n] = i;
                //没冲突就放下一个旗子
                if (!check(n)) {
                    place(n + 1);
                }
                //如果冲突就放到下一列
            }
        }
    }

    /**
     * 检查与之前的n-1个旗子的位置是否有冲突
     *
     * @param n
     */
    public static boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(arr[i] - arr[n]) == Math.abs(i - n)) {
                return true;
            }
        }
        return false;
    }


    public static void print() {
        System.out.println("第" + count++ + "个正确摆放结果 :" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        place(0);

    }


}
