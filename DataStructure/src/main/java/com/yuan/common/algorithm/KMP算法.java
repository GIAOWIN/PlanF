package com.yuan.common.algorithm;

import java.util.Arrays;

public class KMP算法 {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext("ABCDABD");
        System.out.println("next=" + Arrays.toString(next));
        int index = kmpSearch(str1, str2, next);
    }

    /**
     * 获取部分匹配值表
     *
     * @param target 目标子串
     * @return 部分匹配值表
     */
    private static int[] kmpNext(String target) {
        if (null == target || target.length() < 1) {
            return null;
        }
        //创建匹配值表
        int[] next = new int[target.length()];
        //target>=1，第一个位置肯定是0
        next[0] = 0;

        for (int i = 1, j = 0; i < next.length; i++) {

            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }

            //
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            next[i] = j;

        }

        return next;
    }

    /**
     * KMP搜索算法
     *
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表, 是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    private static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str1.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                //找到了 // j = 3 i
                return i - j + 1;
            }
        }
        return -1;
    }

}
