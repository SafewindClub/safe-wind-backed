package com.safewind.infra.security.service;

import com.safewind.common.enums.LoginExceptionEnum;
import com.safewind.common.exception.BizException;
import com.safewind.common.utils.RedisUtil;
import com.safewind.common.constants.CommonRedisConstant;
import com.safewind.infra.security.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  10:45
 * @Description: 用户登录注册服务
 */
@Service
@Slf4j
public class SysLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisUtil redisUtil;

    public String login(String userName,
                        String password,
                        String code,
                        String uuid) {
        // 校验验证码
        validateCaptcha(code, uuid);
        // 用户验证
        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {

            if (e instanceof BadCredentialsException) {
                throw new BizException(LoginExceptionEnum.INVALID_CREDENTIALS);
            } else {
                log.info("用户 {} 登录错误", userName, e);
                throw new BizException(LoginExceptionEnum.INVALID_CREDENTIALS);
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }

    /**
     * 校验验证码
     *
     * @param code 验证码
     * @param uuid uuid
     */
    public void validateCaptcha(String code, String uuid) {
        String captchaCodeKey = CommonRedisConstant.getCaptchaCodeKey(uuid);
        String cacheCode = redisUtil.getCacheObject(captchaCodeKey);
        if (StringUtils.isBlank(cacheCode)) {
            throw new BizException(LoginExceptionEnum.EXPIRED_CAPTCHA);
        }
        redisUtil.deleteObject(captchaCodeKey);
        if (!code.equals(cacheCode)) {
            throw new BizException(LoginExceptionEnum.INVALID);
        }
    }
}
