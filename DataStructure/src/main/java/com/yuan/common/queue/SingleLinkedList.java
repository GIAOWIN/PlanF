package com.yuan.common.queue;

/**
 * @author Yuan-9826
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "");

    /**
     * 按照添加顺序增加一个节点
     *
     * @param node
     */
    public void add(HeroNode node) {
        //头结点不能动
        HeroNode temp = head;
        //一直循环直到找到尾部节点做接下来的操作
        while (temp.next != null) {
            temp = temp.next;
        }
        //找到尾部节点时 赋值
        temp.next = node;
    }

    /**
     * 按照头编号顺序增加一个节点
     *
     * @param node
     */
    public void addByHead(HeroNode node) {
        if (node.head == 0 || node.head <= 0) {
            throw new RuntimeException("数据不合法");
        }
        HeroNode temp = head;
        //头结点不能动
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明已经在最后面了
                temp.next = node;
                break;
            }
            if (temp.next.head > node.head) {
                //位置找到就在temp后面插入
                node.next = temp.next;
                temp.next = node;
                break;

            } else if (temp.next.head == node.head) {
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 展示所有节点
     */
    public void show() {
        //头结点不能动
        HeroNode temp = head;
        //一直循环直到找到尾部节点
        while (temp.next != null) {
            //打印出下一个指向的节点
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    /**
     * 更新或增加一个节点(如果该节点存在)
     *
     * @param newNode
     */
    public void update(HeroNode newNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (newNode.head == temp.head) {
                temp.data = newNode.data;
                return;
            }
        }
        addByHead(newNode);
    }

    /**
     * 删除一个节点
     *
     * @param nodeHead 节点编号
     */
    public void delete(int nodeHead) {
        HeroNode temp = head;
        while (temp != null&&null != temp.next) {
            if (temp.next.head == nodeHead) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int head;
    public String data;
    public HeroNode next;

    public HeroNode(int head, String data) {
        this.head = head;
        this.data = data;
    }

    @Override
    public String toString() {
        return "[" + "head=" + head + ", data='" + data + ']';
    }
}