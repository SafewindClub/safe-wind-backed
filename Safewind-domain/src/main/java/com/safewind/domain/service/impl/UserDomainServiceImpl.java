package com.safewind.domain.service.impl;

import com.safewind.domain.bo.UserBO;
import com.safewind.domain.service.UserDomainService;
import com.safewind.infra.basic.entity.SysUser;
import com.safewind.infra.basic.service.SysUserService;
import com.safewind.infra.basic.service.impl.SysUserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  20:04
 * @Description: TODO
 */
@Service
public class UserDomainServiceImpl implements UserDomainService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserInfoServiceImpl sysUserInfoService;

    /**
     * 查询用户信息
     *
     * @param userId 用户id
     * @return 实例对象
     * */
    @Override
    public UserBO getUserInfo(Long userId) {
        return null;
    }
}
