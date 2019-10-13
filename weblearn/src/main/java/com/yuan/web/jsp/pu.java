package com.yuan.web.jsp;

import com.yuan.util.annotation.NotNull;

public class pu {
    @NotNull
    public static void like(String liek) {
        System.out.println("liek = " + liek);

    }

    public static void main(String[] args) {
        String a = null;
        like(a);
    }
}
