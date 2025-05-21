package com.safewind.common.enums;

import com.safewind.common.exception.BaseExceptionInterface;
import lombok.Getter;

/**
 * @Author: Darven
 * @CreateTime: 2025-03-10  16:52
 * @Description: 返回枚举类
 */
@Getter
public enum ResultCodeEnum implements BaseExceptionInterface {
    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "方法不允许"),
    REQUEST_TIMEOUT(408, "请求超时"),
    TOO_MANY_REQUESTS(429, "请求过于频繁"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    //校验异常
    VALIDATION_FAILED(400, "参数校验失败"),
    ;

    private final Integer code;
    private final String message;

    private ResultCodeEnum(Integer code, String massage){
        this.code=code;
        this.message=massage;
    }

    @Override
    public Integer getErrorCode() {
        return getCode();
    }

    @Override
    public String getErrorMessage() {
        return getMessage();
    }
}
