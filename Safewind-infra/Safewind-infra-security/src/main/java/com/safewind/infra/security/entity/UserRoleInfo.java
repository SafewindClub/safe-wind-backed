package com.safewind.infra.security.entity;

import com.safewind.infra.basic.entity.SysRole;
import lombok.Data;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  20:50
 * @Description: 用户信息和角色实体
 */
@Data
public class UserRoleInfo {
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
     * 角色id
     * */
    private Long roleId;
    /**
     * 用户角色
     * */
    private SysRole role;
}
