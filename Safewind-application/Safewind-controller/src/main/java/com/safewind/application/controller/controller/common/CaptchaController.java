package com.safewind.application.controller.controller.common;

import cn.hutool.core.codec.Base64;
import com.safewind.application.controller.vo.CaptchaVO;
import com.safewind.common.annotation.ApiOperationLog;
import com.safewind.common.enums.ResultCodeEnum;
import com.safewind.common.exception.BizException;
import com.safewind.common.utils.Result;
import com.safewind.common.uuid.IdUtils;
import com.safewind.infra.redis.constants.CommonRedisConstant;
import com.safewind.infra.redis.utils.RedisUtil;
import com.safewind.infra.security.captcha.CaptchaResult;
import com.safewind.infra.security.captcha.CaptchaUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  21:10
 * @Description: 验证码
 */
@RestController
public class CaptchaController {

    @Autowired
    private CaptchaUtil captchaUtil;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 生成验证码
     */
    @ApiOperationLog(description = "验证码获取")
    @GetMapping("/captchaImage")
    public Result<CaptchaVO> getCode(HttpServletResponse response) throws IOException {
        // 生成uuid
        String uuid = IdUtils.simpleUUID();
        String captchaCodeKey = CommonRedisConstant.getCaptchaCodeKey(uuid);

        // 获取验证码
        CaptchaResult captchaResult = captchaUtil.getCaptchaResult();

        // 存储redis
        redisUtil.setCacheObject(captchaCodeKey,
                captchaResult.getCode(),
                CommonRedisConstant.CAPTCHA_EXPIRATION,
                TimeUnit.MINUTES);

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(captchaResult.getImage(), "jpg", os);
        } catch (IOException e) {
            throw new BizException(ResultCodeEnum.INTERNAL_SERVER_ERROR);
        }
        return Result.success(CaptchaVO.builder()
                .uuid(uuid)
                .img(Base64.encode(os.toByteArray()))
                .build());
    }
}
