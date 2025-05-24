package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.SysUserDept;


/**
 * 用户部门映射表(SysUserDept)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface SysUserDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserDept queryById(Long id);



    /**
     * 新增数据
     *
     * @param sysUserDept 实例对象
     * @return 实例对象
     */
    SysUserDept insert(SysUserDept sysUserDept);

    /**
     * 修改数据
     *
     * @param sysUserDept 实例对象
     * @return 实例对象
     */
    SysUserDept update(SysUserDept sysUserDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
