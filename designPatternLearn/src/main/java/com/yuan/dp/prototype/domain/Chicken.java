package com.yuan.dp.prototype.domain;

import java.io.*;

public class Chicken implements Serializable {
     String name;
     String hobby;
     Friend friend;

    public Chicken(String name, String hobby, Friend friend) {
        this.name = name;
        this.hobby = hobby;
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                ", friend=" + friend.hashCode() +
                '}';
    }

    /**
     * 第2种 深拷贝方法 【序列化】
     *
     * @return
     */
    @Override
    public Chicken clone() {
        ByteArrayOutputStream bos;
        ByteArrayInputStream bis;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //当前对象以流的方式输出【一次将本类相关的所有类型都拿过来，再多的属性也不变代码】
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Chicken chicken = (Chicken) ois.readObject();
            return chicken;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关流
        }
    }
}
