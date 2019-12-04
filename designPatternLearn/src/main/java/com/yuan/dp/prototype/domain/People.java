package com.yuan.dp.prototype.domain;

public class People implements Cloneable {

    private String name;
    private int age;
    private Friend friend;

    public People() {
        super();
    }

    public People(String name, int age, Friend friend) {
        this.name = name;
        this.age = age;
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    /**
     * 第1种 深拷贝方法
     *
     * @return
     */
    @Override
    public People clone() {
        People people = null;
        try {
            //1.调用浅拷贝将所有属性的值拷贝过来
            people = (People) super.clone();
            //2.调用引用类型属性的克隆方法覆盖当前的属性值
            people.friend = friend.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name +
                ", age=" + age +
                ", friend=" + friend.hashCode() +
                '}';
    }
}
