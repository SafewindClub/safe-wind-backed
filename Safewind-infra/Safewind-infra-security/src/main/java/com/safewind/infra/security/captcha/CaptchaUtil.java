package com.safewind.infra.security.captcha;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  22:22
 * @Description: 验证码工具
 */
@Service
public class CaptchaUtil {

    @Autowired
    private CaptchaType captchaType;

    public CaptchaResult getCaptchaResult(){
        Producer producer = captchaType.getCaptchaBean();
        String capText = producer.createText();
        String type = captchaType.getType();

        String capStr = null, code = null;
        BufferedImage image = null;

        if("math".equals(type))
        {
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = producer.createImage(capStr);
        }
        else if("char".equals(type))
        {
            capStr = code = capText;
            image = producer.createImage(capStr);
        }

        return CaptchaResult.builder()
                .capStr(capStr)
                .image(image)
                .code(code)
                .build();
    }
}
