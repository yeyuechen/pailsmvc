package com.zz.pail.annotation;


import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 用在参数注解上面
 */
public @interface PailsRequestParam {

    /**
     * 参数的别名,不能为空
     * @return
     */
    String value() ;
}
