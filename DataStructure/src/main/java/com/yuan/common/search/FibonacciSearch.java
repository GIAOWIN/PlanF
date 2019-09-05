package com.yuan.common.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 * @author Yuan-9826
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 189));

    }

    /**
     * 因为后面我们mid=low+F(k-1)-1，需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
    //编写斐波那契查找算法
    //使用非递归的方式编写算法

    /**
     * @param arr 数组
     * @param key 我们需要查找的关键码(值)
     * @return 返回对应的下标，如果没有-1
     */
    private static int fibSearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        //表示斐波那契分割数值的下标
        int k = 0;
        //存放mid值
        int mid = 0;
        //获取到斐波那契数列
        int f[] = fib();

        //得到最大的斐波那契值的下标k
        while (right > f[k] - 1) {
            k++;
        }

        //因为 f[k] 值 可能大于 arr 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需求使用arr数组最后的数填充 temp
        //举例:
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        // 使用while来循环处理，找到我们的数 key
        while (left <= right) {
            // 只要这个条件满足，就可以找
            mid = left + f[k - 1] - 1;
            if (key < temp[mid]) {
                //我们应该继续向数组的前面查找(左边)
                right = mid - 1;
                //为什么是 k--
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {
                // 我们应该继续向数组的后面查找(右边)
                left = mid + 1;
                //为什么是k -=2
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //4. 即在f[k-2] 的前面进行查找 k -=2
                //5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else { //找到
                //需要确定，返回的是哪个下标
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }

}