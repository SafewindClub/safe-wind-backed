package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.SysClub;

/**
 * 社团表(SysClub)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:54
 */
public interface SysClubService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysClub queryById(Long id);



    /**
     * 新增数据
     *
     * @param sysClub 实例对象
     * @return 实例对象
     */
    SysClub insert(SysClub sysClub);

    /**
     * 修改数据
     *
     * @param sysClub 实例对象
     * @return 实例对象
     */
    SysClub update(SysClub sysClub);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
