package com.safewind.common.enums;

import com.safewind.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  09:33
 * @Description: 用户异常枚举类
 */
@Getter
@AllArgsConstructor
public enum UserExceptionEnum implements BaseExceptionInterface {

    DELETE(1100,"账户已删除，请联系管理员"),
    NO_EXIST(1101,"账户不存在"),
    ;

    private final Integer code;
    private final String errorMsg;

    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMessage() {
        return errorMsg;
    }
}
