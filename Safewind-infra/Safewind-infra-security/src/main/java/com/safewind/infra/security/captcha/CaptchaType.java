package com.safewind.infra.security.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  21:41
 * @Description: 验证码类型接口
 */
public interface CaptchaType {
    /**
     * 获得实例
     * */
    DefaultKaptcha getCaptchaBean();

    /**
     * 获得类型
     * */
    String getType();

}
