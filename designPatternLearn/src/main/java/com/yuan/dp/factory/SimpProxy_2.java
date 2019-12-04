package com.yuan.dp.factory;

/**
 * 假装这是一个代理类
 * 只有后置增强
 *
 * @author Yuan-9826
 */
public class SimpProxy_2 {

    String after;


    public SimpProxy_2() {
        System.out.println(this.getClass().getSimpleName()+"类被创建啦");
    }


    /**
     * 假装是设置后置增强方法
     *
     * @param after
     * @return
     */
    public SimpProxy_2 setAfter(String after) {
        if (null != after && this.after == null) {
            this.after = after;
        }
        //谁调用，this就是谁
        return this;
    }

    @Override
    public String toString() {
        return "SimpProxy{" +
                ", after='" + after + '\'' +"成功啦"+
                '}';
    }
}
