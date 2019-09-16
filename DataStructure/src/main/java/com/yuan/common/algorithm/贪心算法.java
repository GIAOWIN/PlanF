package com.yuan.common.algorithm;

import java.util.*;

public class 贪心算法 {
    public static void main(String[] args) throws InterruptedException {
        //创建广播电台,放入到Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> address = new HashSet<String>();
        address.add("北京");
        address.add("上海");
        address.add("天津");
        address.add("广州");
        address.add("深圳");
        address.add("成都");
        address.add("杭州");
        address.add("大连");
//-------------------------------------------------👇👇👇是正文👇👇👇-------------------------------------------------

        //创建ArrayList, 存放选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();

        //定义一个临时的集合， 在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<String>();

        while (address.size() > 0) {
            String name = null;
            tempSet.clear();
            for (Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
                //遍历出每一个广播台以及地址
                String key = entry.getKey();
                HashSet<String> value = entry.getValue();

                //求出vale和地区Set的最大的交集，把最大值的交集取出来[<---这句话是贪心的核心思想]
                HashSet<String> intersection = 求交集(value, address);
                if (intersection.size() > tempSet.size()) {
                    name = key;
                    tempSet.clear();
                    for (String element : intersection) {
                        tempSet.add(element);
                    }
                }
            }
            //for循环结束 将广播的名字添加到集合中。
            selects.add(name);
            //循环删除 并移除地区Set中包含的元素
            for (String element : tempSet) {
                boolean remove = address.remove(element);
            }
            //以及电台Map的元素
            broadcasts.remove(name);
        }

        //得到结果
        System.out.println(selects);
    }


    /**
     * 两个集合求交集 遍历元素少的集合
     */
    public static HashSet<String> 求交集(HashSet<String> set_1, HashSet<String> set_2) {

        HashSet<String> set_new = new HashSet<String>();
        //假设list_2.size()<list_1.size()
        for (String elt : set_2) {
            if (set_1.contains(elt)) {
                set_new.add(elt);
            }
        }

        return set_new;
    }
}
