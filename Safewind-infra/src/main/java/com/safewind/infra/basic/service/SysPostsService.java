package com.safewind.infra.basic.service;

import com.safewind.infra.basic.entity.SysPosts;

/**
 * (SysPosts)表服务接口
 *
 * @author Darven
 * @since 2025-05-21 21:46:55
 */
public interface SysPostsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPosts queryById(Long id);



    /**
     * 新增数据
     *
     * @param sysPosts 实例对象
     * @return 实例对象
     */
    SysPosts insert(SysPosts sysPosts);

    /**
     * 修改数据
     *
     * @param sysPosts 实例对象
     * @return 实例对象
     */
    SysPosts update(SysPosts sysPosts);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
