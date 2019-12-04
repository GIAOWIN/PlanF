package com.yuan.dp.prototype.domain;

import java.io.Serializable;

public class Friend implements Cloneable, Serializable {
    public String name ;
    public String hobby ;

    /**
     * 如果没有引用类型 就用浅拷贝 默认的
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Friend clone() throws CloneNotSupportedException {
        Friend friend = (Friend) super.clone();
        return friend;
    }
}
