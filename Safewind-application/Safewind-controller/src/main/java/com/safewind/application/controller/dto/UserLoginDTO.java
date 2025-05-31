package com.safewind.application.controller.dto;

import com.safewind.common.annotation.Xss;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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
    @Xss
    @NotBlank(message = "用户名不能为空")
    private String userName;
    /**
     * 密码
     * */
    @Xss
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 验证码
     * */
    @Xss
    @NotBlank(message = "验证码不能为空")
    private String code;
    /**
     * 验证码uuid
     * */
    @NotBlank(message = "uuid不能为空")
    private String uuid;
}
