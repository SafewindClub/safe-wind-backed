package com.safewind.domain.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  20:10
 * @Description: 用户角色信息
 */
@Data
@Builder
public class UserRoleBO {
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限字符串
     */
    private String roleKey;
}
