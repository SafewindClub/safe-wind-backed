package com.safewind.infra.basic.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 用户部门映射表(SysUserDept)实体类
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

}

