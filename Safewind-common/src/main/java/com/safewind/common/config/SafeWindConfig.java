package com.safewind.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  21:33
 * @Description: 通用配置类
 */
@Data
@ConfigurationProperties(prefix = "safe-wind")
public class SafeWindConfig {
    // 验证码类型
    private String captchaType;
}
