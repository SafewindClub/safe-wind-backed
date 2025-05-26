package com.safewind.common.enums;

import com.safewind.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  17:01
 * @Description: 登录异常
 */
@Getter
@AllArgsConstructor
public enum LoginExceptionEnum implements BaseExceptionInterface {

    /**
     * 用户名或密码错误
     */
    INVALID_CREDENTIALS(1001, "用户名或密码错误"),

    /**
     * 用户被锁定
     */
    USER_LOCKED(1002, "用户已被锁定，请稍后再试"),

    /**
     * 用户不存在
     */
    USER_NOT_FOUND(1003, "用户不存在"),

    /**
     * 登录失败次数过多，账户被临时锁定
     */
    ACCOUNT_TEMPORARILY_LOCKED(1004, "登录失败次数过多，账户已临时锁定"),

    /**
     * 验证码过期
     */
    EXPIRED_CAPTCHA(1005, "验证码已过期"),

    /**
     * 验证码错误
     */
    INVALID(1005, "验证码错误"),
    ;
    private final int errorCode;
    private final String errorMessage;


    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}

