package com.safewind.common.enums;

import com.safewind.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-27  21:39
 * @Description: 令牌解析错误枚举类
 */
@Getter
@AllArgsConstructor
public enum TokenExceptionEnum implements BaseExceptionInterface {

    PREFIX_ERROR(2000,"不是Bearer 为前缀"),
    JWT_NO_EXIST(2001,"令牌不存在"),
    JWT_EXPIRED(2002,"令牌过期")
    ;

    private final Integer code;
    private final String message;
    @Override
    public Integer getErrorCode() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return "";
    }
}
