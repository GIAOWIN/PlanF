package com.yuan.common.tree.bst;


public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12

        //测试一下删除叶子结点


        binarySortTree.deleteNode(12);


        binarySortTree.deleteNode(5);
        binarySortTree.deleteNode(9);


        System.out.println("root=" + binarySortTree.root);


        System.out.println("删除结点后");
        binarySortTree.infixOrder();
        System.out.println("root=" + binarySortTree.root);
    }
}

/**
 * 二叉排序书
 */
class BinarySortTree {
    Node root;

    /**
     * 添加一个节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            System.out.println("node参数不合法");
            return;
        }
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (null != root) {
            root.infixOrder();
        } else {
            System.out.println("[ null ]");
        }
    }

    /**
     * 查找node节点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }

    }

    /**
     * 查找node的父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }

    }

    /**
     * 删除node节点
     *
     * @param value
     */
    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            //如果没有找到 直接return
            Node node = search(value);
            if (node == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (node.left == null && node.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.left != null && parent.left.value == value) {
                    //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    //是右子结点
                    parent.right = null;
                }
            } else if (node.left != null && node.right != null) {
                //删除有两颗子树的节点
                int minVal = delRightTreeMin(node.right);
                node.value = minVal;


            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (node.left != null) {
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = node.left;
                        } else { //  targetNode 是 parent 的右子结点
                            parent.right = node.left;
                        }
                    } else {
                        root = node.left;
                    }
                } else {
                    //如果要删除的结点有右子结点
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = node.right;
                        } else {
                            //如果 targetNode 是 parent 的右子结点
                            parent.right = node.right;
                        }
                    } else {
                        root = node.right;
                    }
                }

            }
        }
    }

    /**
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        deleteNode(target.value);
        return target.value;
    }


}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 添加一个节点
     *
     * @param node 要添加的节点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            //如果传来的节点值<原来的节点值就往左边放
            if (this.left == null) {
                //如果原节点的左边为空就填值
                this.left = node;
            } else {
                //否则继续比较
                this.left.add(node);
            }
        } else {
            //否则就往右边放
            if (this.right == null) {
                //如果原节点的右边为空就填值
                this.right = node;
            } else {
                //否则继续比较
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (null != this.left) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (null != this.right) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找有无该节点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(value);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(value);
            }
        }
    }

    /**
     * 查找当node的父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                //向左子树递归查找
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                //向右子树递归查找
                return this.right.searchParent(value);
            } else {
                // 没有找到父结点
                return null;
            }
        }
    }



    /**
     * 中序查找Node
     *
     * @param node
     * @return
     */
    private Node infixOrderSearch(Node node) {
        Node val = null;
        if (null != this.left) {
            this.left.infixOrderSearch(node);
        }
        if (this.value == node.value) {
            val = node;
        }
        if (null != this.right) {
            this.right.infixOrderSearch(node);
        }
        return val;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}