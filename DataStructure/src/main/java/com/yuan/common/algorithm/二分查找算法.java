package com.yuan.common.algorithm;


public class 二分查找算法 {
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);

    }

    /**
     * 二分查找算法 非递归算法
     *
     * @param arr    查询数组
     * @param target 目标数值
     * @return 目标数值的下标(若有)
     */
    public static int binarySearch(int[] arr, int target) {
        //定义左右边界
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            //mid是中间的数会变化，所以定义在循环体
            int mid = (right + left) / 2;
            //目标在左边 右边界左移
            if      (arr[mid] >  target) { right = mid-1; }
            //找到目标
            else if (arr[mid] == target) { return mid; }
            //目标在右边 左边界右移
            else                         { left = mid+1; }
        }
        return -1;
    }
}
