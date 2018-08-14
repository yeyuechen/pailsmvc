package com.zz.pail.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * controller 注解，用于标注相关的类
 */
public @interface PailsController {

    /**
     * 给controller注册别名
     * @return
     */
    String value() default "";
}
