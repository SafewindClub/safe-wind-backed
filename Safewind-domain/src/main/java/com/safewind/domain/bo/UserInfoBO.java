package com.safewind.domain.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-29  20:09
 * @Description: 用户详细信息
 */
@Data
@Builder
public class UserInfoBO {
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
}
