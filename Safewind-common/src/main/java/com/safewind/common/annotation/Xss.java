package com.safewind.common.annotation;

import com.safewind.common.aspect.XssValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-31  11:48
 * @Description: 防止XSS攻击
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = XssValidator.class)
public @interface Xss {
    String message() default "输入内容包含非法的 HTML 或脚本内容";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
