package com.yuan.common.queue;

/**
 * 这是一个重复可用的环形链表 但是 数字下标为maxSize的位置没有使用
 */
public class ArrayQueue {
    /**
     * 最大总量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 存放数据用的数组队列
     */
    private int[] queueArray;

    /**
     * 初始化一个maxSize长度的数组队列。
     *
     * @param maxSize
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 往队列中添加一个元素
     *
     * @param element
     * @return
     */
    public boolean addQueue(int element) {

        boolean flag = false;
        if (isFull()) {
            return flag;
        }
        //队尾后移一位
        queueArray[rear] = element;
        rear = (rear + 1) % maxSize;
        flag = true;
        return flag;
    }

    /**
     * @return 弹出&获取当前队首任务
     */
    public int takeQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //队首后移一位
        int value = queueArray[front];
        queueArray[front] = 0;
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列里的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列里没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println("当前数据顺序位数 = " + queueArray[i]);
        }
    }

    /**
     * @return 队列中有效数据个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}