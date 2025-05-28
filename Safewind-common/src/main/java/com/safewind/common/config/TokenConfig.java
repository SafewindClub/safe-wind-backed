package com.safewind.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  17:32
 * @Description: jwt令牌配置类
 */
@Data
@Configuration
@ConfigurationProperties("token")
public class TokenConfig {
    /**
     * 获取请求中的请求头
     * */
    private String header;
    /**
     * 令牌密钥
     * */
    private String secret;
    /**
     * 令牌过期时间
     * */
    private Integer expireTime;
    /**
     * 请求头前缀
     * */
    private String prefix;
}
