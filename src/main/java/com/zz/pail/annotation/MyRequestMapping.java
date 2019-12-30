package com.zz.pail.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 用在方法和类上面的注解
 */
public @interface MyRequestMapping {

    /**
     * 访问该方法的url
     * @return
     */
    String value() default "";
}
