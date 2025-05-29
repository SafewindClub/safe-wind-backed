package com.safewind.domain.service.impl;

import com.safewind.domain.bo.UserBO;
import com.safewind.domain.bo.UserDeptBO;
import com.safewind.domain.bo.UserInfoBO;
import com.safewind.domain.bo.UserRoleBO;
import com.safewind.domain.service.UserDomainService;
import com.safewind.infra.basic.entity.SysUser;
import com.safewind.infra.basic.entity.SysUserInfo;
import com.safewind.infra.basic.service.SysUserService;
import com.safewind.infra.security.entity.LoginUser;
import com.safewind.infra.security.service.SecurityUtil;
import org.springframework.beans.BeanUtils;
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

    /**
     * 查询用户信息,
     * 通过上下文获取用户信息，上下文会解析token去到缓存拿取
     *
     * @return 实例对象
     */
    @Override
    public UserBO getUserInfo() {
        LoginUser loginUser = SecurityUtil.getLoginUser();
        SysUser user = loginUser.getUser();

        UserDeptBO userDeptBO = UserDeptBO.builder()
                .name(user.getDept().getName())
                .build();

        UserRoleBO userRoleBO = UserRoleBO.builder()
                .roleKey(user.getRole().getRoleKey())
                .roleName(user.getRole().getRoleName())
                .build();

        SysUserInfo userInfo = user.getUserInfo();
        UserInfoBO userInfoBO = UserInfoBO.builder().build();
        BeanUtils.copyProperties(userInfo, userInfoBO);

        return UserBO.builder()
                .userId(loginUser.getUserId())
                .email(user.getEmail())
                .studentId(user.getStudentId())
                .userInfo(userInfoBO)
                .dept(userDeptBO)
                .role(userRoleBO)
                .build();
    }
}
