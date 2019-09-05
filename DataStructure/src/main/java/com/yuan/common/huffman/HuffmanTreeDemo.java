package com.yuan.common.huffman;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Yuan-9826
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree();
        //将数组转化为赫夫曼树
        HuffmanNode root = huffmanTree.currentHuffmanTree(arr);
        //前序遍历
        root.preOrder();

    }
}

class HuffmanTree {
    /**
     * 编写一个前序遍历的方法
     */
    public void preOrder(HuffmanNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    /**
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public HuffmanNode currentHuffmanTree(int[] arr) {
        //创建节点集合，并将数组遍历每个值都添加到这个集合中
        ArrayList<HuffmanNode> nodes = new ArrayList<>(arr.length);
        for (int value : arr) {
            nodes.add(new HuffmanNode(value));
        }
        //循环将集合升序排序，用最小两个权值形成二叉树
        while (nodes.size() > 1) {
            //1.将集合升序排序
            Collections.sort(nodes);
            //2.用最小两个权值形成二叉树
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);
            HuffmanNode root = new HuffmanNode(left.value + right.value);
            root.left = left;
            root.right = right;
            //3.移除前两个值让后面的移动两位
            nodes.remove(left);
            nodes.remove(right);
            //4.将新值插入集合
            nodes.add(root);
        }
        return nodes.get(0);
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    /**
     * 权值
     */
    int value;
    /**
     * 左子节点
     */
    HuffmanNode left;
    /**
     * 右子节点
     */
    HuffmanNode right;

    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(HuffmanNode val) {
        //升序排序
        return this.value - val.value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
