package com.safewind.infra.security.captcha;

import lombok.Builder;
import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  22:24
 * @Description: 验证码返回结果
 */
@Data
@Builder
public class CaptchaResult {
    private String capStr;
    private String code;
    private BufferedImage image = null;
}
