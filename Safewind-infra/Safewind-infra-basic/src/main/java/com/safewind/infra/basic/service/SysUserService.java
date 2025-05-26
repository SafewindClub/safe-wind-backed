package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.SysUser;

/**
 * 用户名(SysUser)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Long id);


    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过学生学号查询
     *
     * @param studentId 学号
     * @return 实例对象
     */
    SysUser queryByStudentId(String studentId);
}
