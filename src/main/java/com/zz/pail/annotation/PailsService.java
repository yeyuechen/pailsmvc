package com.zz.pail.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@PailsComponent
/**
 * 用于提供服务端的请求注解
 */
public @interface PailsService {

    String value() default "";
}
