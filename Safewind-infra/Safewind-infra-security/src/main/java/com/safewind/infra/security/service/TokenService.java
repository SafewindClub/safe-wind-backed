package com.safewind.infra.security.service;

import com.safewind.common.config.TokenConfig;
import com.safewind.common.enums.TokenExceptionEnum;
import com.safewind.common.exception.BizException;
import com.safewind.common.utils.RedisUtil;
import com.safewind.common.uuid.IdUtils;
import com.safewind.common.constants.UserRedisConstant;
import com.safewind.infra.security.entity.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  16:42
 * @Description: jwt服务
 */
@Slf4j
@Service
public class TokenService {

    @Autowired
    private TokenConfig tokenConfig;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 生成token
     * 基本逻辑就是，jwt->map->uuid(login_tokens)->loginUsers(login_user_key)
     *
     * @param loginUser 登录用户
     * @return token
     */
    public String createToken(LoginUser loginUser) {
        // 生成uuid，用来存储用户信息到redis
        String uuid = IdUtils.fastUUID();
        loginUser.setToken(uuid);
        refreshToken(loginUser);

        Map<String, Object> claims = new HashMap<>();
        claims.put(UserRedisConstant.LOGIN_TOKENS, uuid);
        // 生成token
        return createToken(claims);
    }

    /**
     * 刷新redis缓存
     * 如果在redis没有，存储到redis
     *
     * @param loginUser 存储用户实例
     */
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + tokenConfig.getExpireTime() * 60 * 1000);
        // 利用uuid作为存储建
        String loginUserKey = UserRedisConstant.getLoginUserKey(loginUser.getToken());
        // 存储redis
        redisUtil.setCacheObject(loginUserKey,
                loginUser,
                tokenConfig.getExpireTime(),
                TimeUnit.MINUTES);
    }

    /**
     * 刷新redis缓存
     * 如果在redis没有，存储到redis
     *
     * @param claims 存储用户键
     * @return token
     */
    private String createToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, tokenConfig.getSecret())
                .compact();
        return token;
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenConfig.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取登录用户信息  request->header->token->claims->loginUser
     *
     * @param request 请求
     * @return 实例对象
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            return getLoginUser(token);
        }
        return null;
    }

    /**
     * 解析jwt令牌 类似：Bearer 为前缀
     */
    private String getToken(HttpServletRequest request) {
        String header = request.getHeader(tokenConfig.getHeader());
        log.info("头部={}", header);
        if (StringUtils.isBlank(header)) {
            return null;
        }

        if (!header.startsWith(tokenConfig.getPrefix())) {
            throw new BizException(TokenExceptionEnum.PREFIX_ERROR);
        }
        // 获取jwt
        return header.replace(tokenConfig.getPrefix() + " ", "");
    }

    /**
     * 通过token解析，然后从redis获取键
     */
    private LoginUser getLoginUser(String token) {
        // 解析
        Claims claims = parseToken(token);
        // 获取用户信息
        String uuid = (String) claims.get(UserRedisConstant.LOGIN_TOKENS);
        String loginUserKey = UserRedisConstant.getLoginUserKey(uuid);
        log.info("角色key={}", loginUserKey);
        // 从redis获取
        Object o = redisUtil.getCacheObject(loginUserKey);
        log.info("获取用户信息={}", o);
        return (LoginUser) o;
    }

    /**
     * 校验用户信息,token小于20分钟自动刷新token
     *
     * @param loginUser 登录用户
     */
    public void verifyToken(LoginUser loginUser) {
        Long expireTime = loginUser.getExpireTime();
        Long loginTime = loginUser.getLoginTime();
        long time = expireTime - loginTime;
        if (time < 0) {
            throw new BizException(TokenExceptionEnum.JWT_EXPIRED);
        }
        // 刷新用户登录时间
        if (time <= 20 * 60 * 1000) {
            refreshToken(loginUser);
        }
    }

    /**
     * 删除redis缓存
     */
    public void delLoginUser(String uuid) {
        if (StringUtils.isNotEmpty(uuid)) {
            String userKey = UserRedisConstant.getLoginUserKey(uuid);
            redisUtil.deleteObject(userKey);
        }
    }

}
