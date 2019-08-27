package com.yuan.common.hashtab;


public class HashTabDemo {

    public static void main(String[] args) {
        HashTable table = new HashTable();
        Emp emp_1 = new Emp(1, "qqq");
        Emp emp_2 = new Emp(2, "www");
        Emp emp_3 = new Emp(3, "eee");
        Emp emp_4 = new Emp(4, "rrr");
        Emp emp_5 = new Emp(112, "qqq");
        Emp emp_6 = new Emp(223, "www");
        Emp emp_7 = new Emp(334, "eee");
        Emp emp_8 = new Emp(445, "rrr");
        table.add(emp_1);
        table.add(emp_2);
        table.add(emp_3);
        table.add(emp_4);
        table.add(emp_5);
        table.add(emp_6);
        table.add(emp_7);
        table.add(emp_8);
        table.show();
    }
}

/**
 * 员工类
 */
class Emp {
    /**
     * id
     */
    private int id;
    /**
     * 名字
     */
    private String name;

    /**
     * 节点信息
     */
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}

/**
 * 员工节点类【单向链表】
 */
class EmpLinkedList {
    private Emp head;

    /**
     * 添加一个节点
     *
     * @param emp
     */
    public void add(Emp emp) {
        //如果的添加第一个成员
        if (head == null) {
            head = emp;
        } else {
            //否则
            Emp currentEmp = head;
            while (currentEmp.next != null) {
                currentEmp = currentEmp.next;
            }
            currentEmp.next = emp;
        }
    }

    /**
     * 展示链表上的所有节点信息
     */
    public void show() {
        if (head == null) {
            System.out.println("没有数据");
        } else {
            Emp curEmp = head;
            while (curEmp != null) {
                System.out.println(curEmp.getId() + "\t\t" + curEmp.getName());
                curEmp = curEmp.next;
            }
        }
    }

    /**
     * 获取链表中有几个节点
     * @return
     */
    public int size() {
        if (head == null) {
            return 0;
        } else {
            int count = 0;
            Emp curEmp = head;
            while (curEmp != null) {
                count++;
                curEmp = curEmp.next;
            }
            return count;
        }
    }

}

/**
 * 员工哈希表
 */
class HashTable {
    /**
     * 假设有5个链表最合理
     */
    private final int SIZE = 5;
    private EmpLinkedList[] empLinkedArray = new EmpLinkedList[SIZE];

    /**
     * 初始化要记得初始化数组，不然默认为null
     */
    public HashTable() {
        for (int x = 0; x < SIZE; x++) {
            empLinkedArray[x] = new EmpLinkedList();
        }
    }

    /**
     * 添加一个节点 调用的是链表方法
     *
     * @param emp
     */
    public void add(Emp emp) {
        int linkedNo = getLinkedNo(emp.getId());
        empLinkedArray[linkedNo].add(emp);
    }

    /**
     * id从零开始，一共5条单向链表
     *
     * @param id
     * @return
     */
    private int getLinkedNo(int id) {
        return id % SIZE;
    }

    public void show() {
        for (int i = 0; i < empLinkedArray.length; i++) {
            if (empLinkedArray[i].size() != 0) {
                empLinkedArray[i].show();
            }
        }
    }
}
