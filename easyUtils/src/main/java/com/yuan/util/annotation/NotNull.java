package com.yuan.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不允许有空值 并把空值打印，或者是不允许指定参数为空，空就打印
 * 如果没有指定参数，那么不允许任何参数为空
 * @author Yuan-9826
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NotNull {
    String value() default "";
    String[] parameter() default {};
}
