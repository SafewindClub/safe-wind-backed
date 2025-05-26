package com.safewind.infra.basic.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 用户名(SysUser)实体类
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -56137085959451306L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 登录用户名，学号
     */
    private String studentId;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信唯一id
     * */
    private String openid;

    /**
     * 用户信息表
     * */
    private SysUserInfo userInfo;

    /**
     * 用户角色
     * */
    private SysRole role;

    /**
     * 部门
     * */
    private SysDept dept;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}

