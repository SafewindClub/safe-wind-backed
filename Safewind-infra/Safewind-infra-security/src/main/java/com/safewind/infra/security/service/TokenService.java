package com.safewind.infra.security.service;

import com.safewind.common.config.TokenConfig;
import com.safewind.common.uuid.IdUtils;
import com.safewind.infra.redis.constants.UserRedisConstant;
import com.safewind.infra.redis.utils.RedisUtil;
import com.safewind.infra.security.entity.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
     * */
    public String createToken(LoginUser loginUser) {
        // 生成uuid，用来存储用户信息到redis
        String uuid = IdUtils.fastUUID();
        loginUser.setToken(uuid);
        refreshToken(loginUser);

        Map<String, Object> claims=new HashMap<>();
        claims.put(UserRedisConstant.LOGIN_TOKENS,uuid);
        // 生成token
        return createToken(claims);
    }

    /**
     * 刷新redis缓存
     * 如果在redis没有，存储到redis
     *
     * @param loginUser 存储用户实例
     * */
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime()+tokenConfig.getExpireTime()*60*1000);
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
     * */
    private String createToken(Map<String, Object> claims)
    {
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
    private Claims parseToken(String token)
    {
        return Jwts.parser()
                .setSigningKey(tokenConfig.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }


}
