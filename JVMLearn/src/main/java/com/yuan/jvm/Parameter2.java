package com.yuan.jvm;

import java.util.Random;

/**
 * @author Yuan-9826
 */
public class Parameter2 {
    public static void main(String[] args) {
        String str = "";
        while (true) {
            str += new Random().nextInt(88888888) + new Random().nextInt(99999999);
        }
    }
}
