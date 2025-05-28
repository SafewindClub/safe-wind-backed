package com.safewind.infra.security.service;

import com.safewind.common.enums.ResultCodeEnum;
import com.safewind.common.exception.BizException;
import com.safewind.infra.security.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-27  22:37
 * @Description: 安全校验工具类
 */
public class SecurityUtil {

    /**
     * 获取用户id
     * */
    public static Long getUserId(){
        LoginUser loginUser = getLoginUser();
        return loginUser.getUserId();
    }

    /**
     * 获取用户信息
     * */
    public static LoginUser getLoginUser(){
        try
        {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new BizException(ResultCodeEnum.UNAUTHORIZED);
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
