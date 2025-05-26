package com.safewind.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  09:29
 * @Description: 用户状态
 */
@Getter
@AllArgsConstructor
public enum UserStatus {
    OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");

    private final String code;
    private final String info;
}
