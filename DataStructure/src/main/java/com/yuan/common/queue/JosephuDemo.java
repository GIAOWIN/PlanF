package com.yuan.common.queue;

public class JosephuDemo {
    public static void main(String[] args) {
        ChildrenSingleLinkedList chrilList = new ChildrenSingleLinkedList();
        chrilList.initBoy(10);
        chrilList.show();
        chrilList.countBoy(1, 2, 10);
        chrilList.show();
    }

}

/**
 * 链表类
 */
class ChildrenSingleLinkedList {
    //创建一个当前节点
    Boy firstBoy = null;

    /**
     * 初始化一个有指定个数节点的链表
     *
     * @param num 个数
     */
    public void initBoy(int num) {
        if (num < 3) {
            System.out.println("传入的参数有问题");
            return;
        }
        //辅助指针
        Boy currentBoy = null;
        for (int i = 1; i <= num; i++) {
            //第一个特殊照顾一下
            Boy boy = new Boy(i);
            if (i == 1) {
                firstBoy = boy;
                firstBoy.setNext(firstBoy);
                currentBoy = firstBoy;
            } else {
                currentBoy.setNext(boy);
                boy.setNext(firstBoy);
                currentBoy = boy;
            }
        }
    }

    public void show() {
        Boy currentBoy = firstBoy;
        while (currentBoy.getNext() != firstBoy) {
            System.out.println(currentBoy.getNo() + "号小男孩正在原地待命");
            currentBoy = currentBoy.getNext();
        }
    }

    /**
     * @param startNum 开始数数的小孩编号
     * @param countNum 数到几被弹出
     * @param num      初始人数
     */
    public void countBoy(int startNum, int countNum, int num) {
        //对数据校验
        if (startNum > num || startNum == 0 || countNum == 0 || num == 0 || firstBoy == null) {
            System.out.println("参数有问题");
            return;
        }

        initBoy(num);
        //首先 一直循环到只剩一个为止
        while (firstBoy.getNext() != firstBoy) {

            Boy temp = null;
            //从startNum编号开始 循环countNum次，最后一位干掉
            if (firstBoy.getNo() == startNum) {
                //循环countNum次，
                for (int a = 1; a <= countNum; a++) {
                    //最后一位干掉

/**
 *  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 *
 *
 *
 *
 *                  具体操作日后谈
 *
 *
 *
 *
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 */
                    firstBoy = firstBoy.getNext();
                }
            }

            //每次循环结束都要往下移一位，直到还剩下最后一个结束
            firstBoy = firstBoy.getNext();
        }


    }
}


/**
 * 节点类
 */
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }


}
