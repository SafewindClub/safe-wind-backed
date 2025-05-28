package com.safewind.common.constants;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  22:06
 * @Description: 通用缓存常量
 */
public class CommonRedisConstant {
    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    public static String getCaptchaCodeKey(String uuid){
        return CAPTCHA_CODE_KEY+uuid;
    }
}
