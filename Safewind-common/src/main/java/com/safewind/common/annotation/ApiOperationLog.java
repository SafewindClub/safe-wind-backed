package com.safewind.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: Darven
 * @CreateTime: 2025-03-26  19:43
 * @Description: TODO
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
