package com.yuan.common.tree;


/**
 *
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


    /**
     * 前序遍历查找 根据编号
     *
     * @param no
     * @return
     */
    public DataNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 中序遍历查找 根据编号
     *
     * @param no
     * @return
     */
    public DataNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * 后序查找 根据编号
     */
    public DataNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
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

    /**
     * 前序遍历查找 根据编号
     *
     * @return
     */
    public DataNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到结点，则返回
        DataNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        //说明我们左子树找到
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中序遍历查找 根据编号
     *
     * @return
     */
    public DataNode infixOrderSearch(int no) {
        //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        DataNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序查找");
        //如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        if (this.no == no) {
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 后序遍历查找 根据编号
     *
     * @return
     */
    public DataNode postOrderSearch(int no) {

        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        DataNode resNode = null;
        if (this.left != null) {
            resNode = postOrderSearch(no);
        }
        //说明在左子树找到
        if (resNode != null) {
            return resNode;
        }
        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        //在右子树找到
        if (resNode != null) {
            return resNode;
        }//如果左右子树都没有找到，就比较当前结点是不是
        if (this.no == no) {
            return this;
        }

        return resNode;
    }


    /**
     * 递归删除结点
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     *
     * @param no
     */
    public void delNode(int no) {
//如果是头结点是目标 就在树结构中删除
//	1. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
//	2. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
//	3. 如果第1和第2步没有删除结点，那么我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
//	4.  如果第3步也没有删除结点，则向右子树进行递归删除.
        if (this.right != null) {
            this.right.delNode(no);
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

    }
}
