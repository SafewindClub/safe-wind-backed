package com.safewind.infra.security.service;

import com.safewind.common.enums.UserExceptionEnum;
import com.safewind.common.enums.UserStatus;
import com.safewind.common.exception.BizException;
import com.safewind.infra.basic.entity.SysUser;
import com.safewind.infra.basic.service.SysUserService;
import com.safewind.infra.security.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  08:32
 * @Description: 重写security UserDetailsService 实现自定义用户验证
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;


    /**
     * @param username 用户名 这里是学号
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询数据库
        SysUser sysUser = sysUserService.queryByStudentId(username);
        log.info("登录查询的用户信息={}",sysUser);
        if(Objects.isNull(sysUser)){
            log.info("登录用户：{} 不存在.", username);
            throw new BizException(UserExceptionEnum.NO_EXIST);
        }
        else if(UserStatus.DELETED.getCode().equals(sysUser.getDelFlag())){
            log.info("登录用户：{} 已被删除.", username);
            throw new BizException(UserExceptionEnum.DELETE);
        }
        // todo 密码校验次数
        // 组装返回UserDetails
        return buildUserDetail(sysUser);
    }

    private UserDetails buildUserDetail(SysUser sysUser) {
        return new LoginUser(sysUser.getId(), sysUser);
    }
}
