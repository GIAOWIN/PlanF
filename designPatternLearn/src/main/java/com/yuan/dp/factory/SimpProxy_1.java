package com.yuan.dp.factory;

/**
 * 假装这是一个代理类
 * 只有前置增强
 * @author Yuan-9826
 */
public class SimpProxy_1 {

    String before;



    public SimpProxy_1() {
        System.out.println(this.getClass().getSimpleName()+"类被创建啦");
    }

    /**
     * 假装是设置前置增强方法
     *
     * @param before
     * @return
     */
    public SimpProxy_1 setBefore(String before) {
        if (null != before && this.before == null) {
            this.before = before;
        }
        //谁调用，this就是谁
        return this;
    }



    @Override
    public String toString() {
        return "SimpProxy{" +
                "before='" + before + '\'' +"成功啦"+
                '}';
    }
}
