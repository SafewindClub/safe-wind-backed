package com.safewind.application.controller.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  21:11
 * @Description: 验证码返回体
 */
@Data
@Builder
public class CaptchaVO {
    /**
     * uuid，追踪验证码
     * */
    public String uuid;

    /**
     * 图片base64字符串
     * */
    public String img;
}
