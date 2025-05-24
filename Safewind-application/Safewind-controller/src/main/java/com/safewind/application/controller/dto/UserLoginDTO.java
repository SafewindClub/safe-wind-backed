package com.safewind.application.controller.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-23  23:37
 * @Description: 登录dto
 */
@Data
public class UserLoginDTO {
    /**
     * 用户名
     * */
    private String userName;
    /**
     * 密码
     * */
    private String password;
    /**
     * 验证码
     * */
    private String code;
    /**
     * 验证码uuid
     * */
    private UUID uuid;
}
