package org.format.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FormObj {

    //参数别名
    String value() default "";

    //是否展示, 默认展示
    boolean show() default true;

}
