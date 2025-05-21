package com.safewind.common.exception;

/**
 * @Author: Darven
 * @CreateTime: 2025-03-26  19:08
 * @Description: 通用异常接口
 */
public interface BaseExceptionInterface {
    // 错误码
    Integer getErrorCode();
    // 错误信息
    String getErrorMessage();
}
