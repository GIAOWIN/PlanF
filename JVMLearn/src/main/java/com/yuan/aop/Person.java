package com.yuan.aop;

/**
 * @author Yuan-9826
 */
public class Person {
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println("我中午吃了" + food);
    }



    public void eat(String name,Object[] foods){
        StringBuffer sb = new StringBuffer();
        for (Object food : foods) {
            sb.append(food + " ");
        }

        System.out.println("我 "+ name +" 中午吃了" + sb.toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
