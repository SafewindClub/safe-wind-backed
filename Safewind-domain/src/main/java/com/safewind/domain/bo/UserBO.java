package com.safewind.domain.bo;

import lombok.Builder;
import lombok.Data;


/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  20:01
 * @Description: 领域用户信息
 */
@Data
@Builder
public class UserBO {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 登录用户名，学号
     */
    private String studentId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户信息表
     * */
    private UserInfoBO userInfo;

    /**
     * 用户角色
     * */
    private UserRoleBO role;

    /**
     * 部门
     * */
    private UserDeptBO dept;
}
