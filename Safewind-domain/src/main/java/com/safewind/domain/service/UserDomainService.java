package com.safewind.domain.service;

import com.safewind.domain.bo.UserBO;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  20:00
 * @Description: 用户业务模块
 */
public interface UserDomainService {
    /**
     * 查询用户信息（用户中心）
     * */
    UserBO getUserInfo(Long userId);

}
