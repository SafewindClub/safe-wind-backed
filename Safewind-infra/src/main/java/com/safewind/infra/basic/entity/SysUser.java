package com.safewind.infra.basic.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 用户名(SysUser)实体类
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
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

    private String openid;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

