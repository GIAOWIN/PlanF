package com.yuan.test;

import com.yuan.commons.CommonUtils;
import org.junit.Test;

public class EasyUtuilsTest {

    @Test
    public void uuidTest() {
        final String uuid = CommonUtils.uuid();
        System.out.println("uuid = " + uuid);
        //uuid = 3CA463D3B21E46179A25157E8A80BF2A
    }


}
