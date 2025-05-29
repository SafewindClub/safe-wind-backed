package com.safewind.infra.basic.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 用户部门映射表(SysUserDept)实体类
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
@Data
public class SysUserDept implements Serializable {
    private static final long serialVersionUID = -90674086055997750L;

    private Long id;
    /**
     * 用户id
     */
    private Long userId;

    private Long deptId;
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

