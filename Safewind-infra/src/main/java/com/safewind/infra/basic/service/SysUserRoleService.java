package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.SysUserRole;

/**
 * 用户和角色关联表(SysUserRole)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface SysUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUserRole queryById(Long userId);



    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    SysUserRole insert(SysUserRole sysUserRole);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    SysUserRole update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}
