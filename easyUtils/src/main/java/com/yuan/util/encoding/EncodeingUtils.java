package com.yuan.util.encoding;

import com.yuan.util.annotation.NotNull;

import java.io.UnsupportedEncodingException;

/**
 * 编码转换
 */
public class EncodeingUtils {
    /**
     * iso-8859-1 转成 utf-8
     *
     * @param code
     * @return
     */
    @NotNull
    public static String i2u(String code) {
        try {
            return new String(code.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("转码失败");
        }
    }

    /**
     * iso-8859-1 转成 gbk
     *
     * @param code
     * @return
     */
    public static String i2g(String code) {
        try {
            return new String(code.getBytes("iso-8859-1"), "gbk");
        } catch (UnsupportedEncodingException e) {
            new RuntimeException("转码失败");
            return null;
        }
    }

    /**
     * gbk 转成 iso-8859-1
     *
     * @param code
     * @return
     */
    public static String g2i(String code) {
        try {
            return new String(code.getBytes("gbk"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            new RuntimeException("转码失败");
            return null;
        }
    }

    /**
     * gbk 转成 utf-8
     *
     * @param code
     * @return
     */
    public static String g2u(String code) {
        try {
            return new String(code.getBytes("gbk"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            new RuntimeException("转码失败");
            return null;
        }
    }


    /**
     * utf-8 转成 iso-8859-1
     *
     * @param code
     * @return
     */
    public static String u2i(String code) {
        try {
            return new String(code.getBytes("utf-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            new RuntimeException("转码失败");
            return null;
        }
    }

    /**
     * utf-8 转成 gbk
     *
     * @param code
     * @return
     */
    public static String u2g(String code) {
        try {
            return new String(code.getBytes("utf-8"), "gbk");
        } catch (UnsupportedEncodingException e) {
            new RuntimeException("转码失败");
            return null;
        }
    }


}
