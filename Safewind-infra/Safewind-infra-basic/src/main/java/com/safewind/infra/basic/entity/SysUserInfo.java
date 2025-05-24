package com.safewind.infra.basic.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * 成员信息表(SysUserInfo)实体类
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
@Data
public class SysUserInfo implements Serializable {
    private static final long serialVersionUID = 261428664171350859L;

    private Long id;
    /**
     * 系统用户id，sysUserid
     */
    private Long sysUserId;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 头像 ，程序层默认一张图
     */
    private String avatar;
    /**
     * 年级，形如 ‘2025’ 的字符串
     */
    private String grade;
    /**
     * 专业
     */
    private String speciality;
    /**
     * 学院
     */
    private String faculty;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别，“1，男“，”0，女“
     */
    private Integer sex;
    /**
     * 班级
     */
    private String className;
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

