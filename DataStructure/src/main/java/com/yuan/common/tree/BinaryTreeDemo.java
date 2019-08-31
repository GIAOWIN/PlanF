package com.yuan.common.tree;


/**
 * @author Yuan-9826
 */

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        DataNode root = new DataNode(1, "root-根节点");
        DataNode left_1 = new DataNode(2, "left-左子节点1");
        DataNode right_1 = new DataNode(3, "right-右节点1");
        DataNode left_2 = new DataNode(4, "left-左子节点2");
        DataNode right_2 = new DataNode(3, "right-右节点2");
        root.setLeft(left_1);
        root.setRight(right_1);
        left_1.setLeft(left_2);
        left_1.setRight(right_2);
        bt.setRoot(root);
        bt.preOrder();
    }
}

/**
 * 二叉树类
 */
class BinaryTree {
    /**
     * 根节点
     */
    private DataNode root;

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (null != this.root) {
            this.root.preOrder();
        } else {
            System.out.println("当前节点为null");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (null != this.root) {
            this.root.infixOrder();
        } else {
            System.out.println("当前节点为null");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (null != this.root) {
            this.root.postOrder();
        } else {
            System.out.println("当前节点为null");
        }
    }

    public DataNode getRoot() {
        return root;
    }

    public void setRoot(DataNode root) {
        this.root = root;
    }
}

/**
 * 数据节点类
 */
class DataNode {
    /**
     * 编号
     */
    private int no;
    /**
     * 存放的数据
     */
    private String data;
    /**
     * 左子节点 默认null
     */
    private DataNode left;
    /**
     * 右子节点 默认null
     */
    private DataNode right;


    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (null != this.left) {
            this.left.preOrder();
        }
        if (null != this.right) {

            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        System.out.println(this);
        if (null != this.left) {
            this.left.infixOrder();
        }
        if (null != this.right) {

            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        System.out.println(this);
        if (null != this.left) {
            this.left.postOrder();
        }
        if (null != this.right) {

            this.right.postOrder();
        }
    }


    public DataNode(int no, String data) {
        this.no = no;
        this.data = data;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataNode getLeft() {
        return left;
    }

    public void setLeft(DataNode left) {
        this.left = left;
    }

    public DataNode getRight() {
        return right;
    }

    public void setRight(DataNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        if (no == 1) {
            StringBuffer str = new StringBuffer("DataNode{" + "no=" + no);
            if (data != null) {
                str.append(", data='" + data);
            }
            if (null != left) {
                str.append(", left=" + left);

            }
            if (right != null) {
                str.append(", right=" + right);
            }
            return str.toString();
        }else {
            return "";
        }

    }
}
