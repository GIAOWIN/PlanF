package com.yuan.common.tree;

/**
 * @author Yuan-9826
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); //结果：1,2,4,5,3,6,7
    }
}

class ArrBinaryTree {
    /**
     * 存储数据结点的数组
     */
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载preOrder方法
     */
    public void preOrder() {
        //从0开始遍历
        preOrder(0);
    }

    /**
     * 完成前序存储二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    private void preOrder(int index) {

        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //输出当前这个元素
        System.out.print(arr[index] + "\t");

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}