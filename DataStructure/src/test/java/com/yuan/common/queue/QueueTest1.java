package com.yuan.common.queue;

public class QueueTest1 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        boolean full1 = queue.isFull();
        boolean empty1 = queue.isEmpty();
        System.out.println("empty1 = " + empty1);
        System.out.println("full1 = " + full1);
        queue.showQueue();//
        System.out.println("-------------------------------");

        boolean b1 = queue.addQueue(5);
        boolean b2 = queue.addQueue(1);
        boolean b3 = queue.addQueue(3);
        boolean b4 = queue.addQueue(6);
        boolean b5 = queue.addQueue(7);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);
        System.out.println("b4 = " + b4);
        System.out.println("b5 = " + b5);

        boolean empty2 = queue.isEmpty();
        System.out.println("empty2 = " + empty2);
        boolean full2 = queue.isFull();
        System.out.println("full2 = " + full2);

      //  int la = queue.takeQueue();
      //  System.out.println("队首任务 = " + la);


        queue.showQueue();
        System.out.println(queue.size());
    }
}
class QueueTest2 {
    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.addByHead(new HeroNode(3, "王五"));
        list.addByHead(new HeroNode(3, "王五"));
        list.addByHead(new HeroNode(1, "张三"));
        list.addByHead(new HeroNode(3, "王五"));
        list.addByHead(new HeroNode(2, "李四"));
        list.addByHead(new HeroNode(2, "李四"));
        list.addByHead(new HeroNode(2, "李四"));
        list.addByHead(new HeroNode(4, "赵六"));
        list.show();
        System.out.println("----------------------");
        list.update(new HeroNode(3, "新_王五"));
        list.show();
        System.out.println("----------------------");
        list.update(new HeroNode(5, "张龙赵虎王朝马汉"));
        list.show();
        System.out.println("----------------------");
        list.delete(1);
        list.delete(5);
        list.show();
    }
}
