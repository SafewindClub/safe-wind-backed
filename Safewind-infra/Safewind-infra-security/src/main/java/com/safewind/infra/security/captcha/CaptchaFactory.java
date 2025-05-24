package com.safewind.infra.security.captcha;

import com.google.common.base.Optional;
import com.safewind.common.config.SafeWindConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  21:40
 * @Description: 验证码类型工厂
 */
@Component
public class CaptchaFactory {

    @Autowired
    private SafeWindConfig safeWindConfig;

    @Bean
    public CaptchaType getBean(){
        String type = safeWindConfig.getCaptchaType();
        if ("math".equals(type)) {
            return new CaptchaMathProducer();
        } else if ("char".equals(type)) {
            return new CaptchaCharProducer();
        } else {
            throw new IllegalArgumentException("Unsupported captcha type: " + type);
        }
    }
}
