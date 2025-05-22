package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.SysClubDept;

/**
 * 社团部门映射表(SysClubDept)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:54
 */
public interface SysClubDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysClubDept queryById(Long id);



    /**
     * 新增数据
     *
     * @param sysClubDept 实例对象
     * @return 实例对象
     */
    SysClubDept insert(SysClubDept sysClubDept);

    /**
     * 修改数据
     *
     * @param sysClubDept 实例对象
     * @return 实例对象
     */
    SysClubDept update(SysClubDept sysClubDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
